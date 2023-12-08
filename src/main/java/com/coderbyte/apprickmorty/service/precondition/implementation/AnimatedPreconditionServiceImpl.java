package com.coderbyte.apprickmorty.service.precondition.implementation;

import com.coderbyte.apprickmorty.controller.dto.AnimatedCharacterDTO;
import com.coderbyte.apprickmorty.exception.BusinessException;
import com.coderbyte.apprickmorty.model.CalledTables;
import com.coderbyte.apprickmorty.model.SystemError;
import com.coderbyte.apprickmorty.model.TypeRequest;
import com.coderbyte.apprickmorty.service.CalledTablesService;
import com.coderbyte.apprickmorty.service.SystemErrorService;
import com.coderbyte.apprickmorty.service.precondition.AnimatedPreconditionService;
import com.coderbyte.apprickmorty.utils.Constants;
import com.coderbyte.apprickmorty.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AnimatedPreconditionServiceImpl implements AnimatedPreconditionService {

    private CalledTablesService calledTablesService;
    private SystemErrorService systemErrorService;

    @Autowired
    public AnimatedPreconditionServiceImpl(CalledTablesService calledTablesService, SystemErrorService systemErrorService) {
        this.calledTablesService = calledTablesService;
        this.systemErrorService = systemErrorService;
    }

    @Override
    public void checkOrderBy(String order) {
        if (!NumberUtil.isNumeric(order)) {
            String code = "301-1";
            String status = HttpStatus.BAD_REQUEST.name();
            String message = "This value must be of type Integer.";

            manageErrorData(Constants.PARAMETER, order, code, status, message, TypeRequest.GET.name());
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

        if (Objects.isNull(dto.getImage()) || dto.getImage().length() == 0) {
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
        if (Objects.isNull(dto.getStatus()) || dto.getStatus().length() == 0) {
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

            manageErrorData(Constants.PARAMETER, initPage, code, status, message, TypeRequest.GET.name());
        }

        if (!NumberUtil.isNumeric(initPage)) {
            code = "301-6";
            status = HttpStatus.BAD_REQUEST.name();
            message = "This value initPage must be of type Integer.";

            manageErrorData(Constants.PARAMETER, initPage, code, status, message, TypeRequest.GET.name());
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

            manageErrorData(Constants.PARAMETER, sizePage, code, status, message, TypeRequest.GET.name());
        }

        if (!NumberUtil.isNumeric(sizePage)) {
            code = "301-8";
            status = HttpStatus.BAD_REQUEST.name();
            message = "This value sizePage must be of type Integer.";

            manageErrorData(Constants.PARAMETER, sizePage, code, status, message, TypeRequest.GET.name());
        }
    }

    private void manageErrorData(String parameter, Object dto, String code, String status, String message, String typeReq) {
        CalledTables tables = calledTablesService.addCalledTables(parameter, dto, typeReq);
        SystemError error = systemErrorService.addSystemError(code, status, message);
        calledTablesService.postCalledTablesWithError(tables, error);

        throw new BusinessException(code, HttpStatus.BAD_REQUEST, message);
    }
}
