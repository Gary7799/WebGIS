package com.cepri.gygis.core.repository;

import com.cepri.gygis.core.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, String> {

}
