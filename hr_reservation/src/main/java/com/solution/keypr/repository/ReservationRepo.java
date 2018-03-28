/**
 * To update all non ID fields of a reservation
 */
package com.solution.keypr.repository;

import org.springframework.stereotype.Repository;

import com.solution.keypr.domain.Reservation;

/**
 * @author RAM
 *
 */
@Repository
public class ReservationRepo extends DataRepository <Reservation> {
	protected void updateIfExists(Reservation original, Reservation updated) {
		original.setgFullName(updated.getgFullName());
		original.setCheckinDate(updated.getCheckinDate());
		original.setCheckoutDate(updated.getCheckoutDate());
		original.setRStatus(updated.Rstatus());
	}

}
