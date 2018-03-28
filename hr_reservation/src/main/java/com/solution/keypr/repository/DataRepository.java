/**
 * An abstract class for the Data store/Repository
 */
package com.solution.keypr.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.solution.keypr.domain.Identifiable;

/**
 * @author RAM
 *
 */

public abstract class DataRepository<T extends Identifiable> {

	@Autowired
	private UniIDGenerator uniIDGenerator;
	
	private List<T> reservations = Collections.synchronizedList(new ArrayList<>());

	public T create(T reservation) {
		reservations.add(reservation);
		reservation.setId(uniIDGenerator.getNextId());
		return reservation;
	}
	
	public List<T> findAll(){
	
		return reservations;
	}
	
	public Optional<T> findById(Long rid) {
		return reservations.stream().filter(r -> r.getId().equals(rid)).findFirst();
	}
	
	public void clear() {
		reservations.clear();
	}
	
	public int getCount() {
		return reservations.size();
	}
	
	public boolean update(Long rid, T updated) {
		if (updated == null) {
			return false;
		}
		else {
			Optional<T> reservation = findById(rid);
			reservation.ifPresent(original -> updateIfExists(original, updated));
			return reservation.isPresent();
		}
	}

	protected abstract void updateIfExists(T original, T desired);
	
}
