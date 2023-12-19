package com.coderbyte.apprickmorty.infrastructure.repositories;

import com.coderbyte.apprickmorty.domian.ports.out.AnimatedPreconditionRepositoryPort;
import com.coderbyte.apprickmorty.infrastructure.entities.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.CalledTablesDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.SystemErrorDTO;
import com.coderbyte.apprickmorty.infrastructure.entities.TypeRequest;
import com.coderbyte.apprickmorty.infrastructure.exception.BusinessException;
import com.coderbyte.apprickmorty.infrastructure.util.Constantes;
import com.coderbyte.apprickmorty.infrastructure.util.NumberUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class JpaAnimatedPreconditionRepositoryAdapter implements AnimatedPreconditionRepositoryPort {

    private final JpaCalledTablesRepositoryAdapter jpaCalledTablesRepositoryAdapter;
    private final JpaSystemErrorRepositoryAdapter jpaSystemErrorRepositoryAdapter;

    @Override
    public void checkOrderBy(String order) {
        if (!NumberUtil.isNumeric(order)) {
            String code = "301-1";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "This value must be of type Integer.";

            manageErrorData(Constantes.PARAMETER, order, code, status, message, TypeRequest.GET.name());
        }
    }

    @Override
    public void checkNullBodyField(AnimatedCharacterDTO dto) {

        if (Objects.isNull(dto.getName()) || dto.getName().length() == 0) {
            String code = "301-2";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "The name attribute cannot be null or empty.";

            manageErrorData(AnimatedCharacterDTO.class.toString(), dto, code, status, message, TypeRequest.POST.name());
        }

        if (Objects.isNull(dto.getPicture()) || dto.getPicture().length() == 0) {
            String code = "301-3";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "The image attribute cannot be null or empty.";

            manageErrorData(AnimatedCharacterDTO.class.toString(), dto, code, status, message, TypeRequest.POST.name());
        }
        if (Objects.isNull(dto.getGender()) || dto.getGender().length() == 0) {
            String code = "301-4";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "The gender attribute cannot be null or empty.";

            manageErrorData(AnimatedCharacterDTO.class.toString(), dto, code, status, message, TypeRequest.POST.name());
        }
        if (Objects.isNull(dto.getState()) || dto.getState().length() == 0) {
            String code = "301-5";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "The status  attribute cannot be null or empty.";

            manageErrorData(AnimatedCharacterDTO.class.toString(), dto, code, status, message, TypeRequest.POST.name());
        }
    }

    @Override
    public void checkInitPageBy(String initPage) {
        String code = "";
        String status = "";
        String message = "";
        if (Objects.isNull(initPage) || initPage.length() == 0) {
            code = "301-6";
            status = HttpStatus.BAD_REQUEST.name();
            message = "The initPage  attribute cannot be null or empty.";

            manageErrorData(Constantes.PARAMETER, initPage, code, status, message, TypeRequest.GET.name());
        }

        if (!NumberUtil.isNumeric(initPage)) {
            code = "301-6";
            status = HttpStatus.BAD_REQUEST.name();
            message = "This value initPage must be of type Integer.";

            manageErrorData(Constantes.PARAMETER, initPage, code, status, message, TypeRequest.GET.name());
        }
    }

    @Override
    public void checkSizePageBy(String sizePage) {
        String code = "";
        String status = "";
        String message = "";
        if (Objects.isNull(sizePage) || sizePage.length() == 0) {
            code = "301-7";
            status = HttpStatus.BAD_REQUEST.name();
            message = "The sizePage  attribute cannot be null or empty.";

            manageErrorData(Constantes.PARAMETER, sizePage, code, status, message, TypeRequest.GET.name());
        }

        if (!NumberUtil.isNumeric(sizePage)) {
            code = "301-8";
            status = HttpStatus.BAD_REQUEST.name();
            message = "This value sizePage must be of type Integer.";

            manageErrorData(Constantes.PARAMETER, sizePage, code, status, message, TypeRequest.GET.name());
        }
    }

    private void manageErrorData(String parameter, Object dto, String code, String status, String message, String typeReq) {
        CalledTablesDTO tablesDTO = jpaCalledTablesRepositoryAdapter.addCalledTables(parameter, dto, typeReq);
        SystemErrorDTO errorDTO = jpaSystemErrorRepositoryAdapter.addSystemError(code, status, message);
        jpaCalledTablesRepositoryAdapter.saveWithError(tablesDTO, errorDTO);

        throw new BusinessException(code, HttpStatus.BAD_REQUEST, message);
    }
}
