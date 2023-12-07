package com.coderbyte.apprickmorty.service;

import com.coderbyte.apprickmorty.model.SystemError;
import org.springframework.stereotype.Service;

@Service
public interface SystemErrorService {
    SystemError postSystemError(SystemError systemError);
}
