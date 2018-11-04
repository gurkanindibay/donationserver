package org.donationtracker.donationserver.security.configuration;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.donationtracker.donationserver.security.model.User;
import org.donationtracker.donationserver.security.enums.UserOperationType;
import org.donationtracker.donationserver.security.model.UserOperationsLog;
import org.donationtracker.donationserver.security.repository.SysUserOperationsLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@Slf4j
public class UserOperationLoggerUtil {

    private final SysUserOperationsLogRepository sysUserOperationsLogRepository;

    private final AuditorAwareImpl auditorAware;

    @Autowired
    public UserOperationLoggerUtil(SysUserOperationsLogRepository sysUserOperationsLogRepository, AuditorAwareImpl auditorAware) {
        this.sysUserOperationsLogRepository = sysUserOperationsLogRepository;
        this.auditorAware = auditorAware;
    }

    public UserOperationType getOperationType(String entityName, UserOperationType operation) {
        for (UserOperationType type : UserOperationType.values()) {
            if (type.getClazz() != null && entityName.equalsIgnoreCase(type.getClazz().getSimpleName()) && operation.name()
                    .equals(type.getOperation())) {
                return type;
            }
        }

        return null;
    }

    public void saveUserOperation(UserOperationType operationType, String description) {
        if (auditorAware.getCurrentAuditor().isPresent())
            saveOperationLog(operationType, description, auditorAware.getCurrentAuditor().get());
        else
            log.warn("User does not exist for loogging");
    }

    public void saveUserOperation(UserOperationType operationType, String description, User user) {
        saveOperationLog(operationType, description, user);
    }

    private void saveOperationLog(UserOperationType operationType, String description, User user) {
        UserOperationsLog sysUserOperationsLog = new UserOperationsLog();
        sysUserOperationsLog.setCreatedDate(new Date());
        sysUserOperationsLog.setOperation(operationType);
        sysUserOperationsLog.setDescription(description);
        sysUserOperationsLog.setUser(user);
        sysUserOperationsLogRepository.save(sysUserOperationsLog);
    }

}
