package com.appointment.appointment.repository;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointment.appointment.model.Trackingslot;


@Repository
public interface TrackingslotRepository extends JpaRepository<Trackingslot, String>
{
	long countByServiceidAndTime(String id,Date apptime);
}

