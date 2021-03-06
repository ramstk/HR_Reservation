/**
 * The unique ID for the domain objects
 */
package com.solution.keypr.domain;

/**
 * @author RAM
 *
 */
public interface Identifiable extends org.springframework.hateoas.Identifiable<Long> {

	public void setId(Long rid);
}
