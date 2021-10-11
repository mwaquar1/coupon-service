package com.waquar.springcloud.couponservice.repository;

import com.waquar.springcloud.couponservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
