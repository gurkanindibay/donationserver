package org.donationtracker.donationserver.security.repository;

import org.donationtracker.donationserver.security.model.UserOperationsLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserOperationsLogRepository extends JpaRepository<UserOperationsLog, Long> {
}
