package com.ulco.curae.repository;

import com.ulco.curae.model.HospitalizationDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface IHospitalizationRepository extends JpaRepository<HospitalizationDO, Integer> {
    List<HospitalizationDO>findByServiceId(Integer id);
    List<HospitalizationDO>findByStartDateBeforeAndEndDateAfter(Date startDate, Date endDate);
}
