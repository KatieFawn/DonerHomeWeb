package com.donerhome.repository;

import com.donerhome.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for performing CRUD operations on the Address entity.
 * Extends JpaRepository to provide basic database operations.
 */
public interface AddressRepository extends JpaRepository<Address, Long> {

    /**
     * Deletes all Address records associated with a specific userId.
     *
     * @param userId The user ID whose addresses should be deleted.
     * @return The number of records deleted.
     */
    Long deleteByUserId(Long userId);

    /**
     * Retrieves all Address records associated with a specific userId.
     *
     * @param userId The user ID whose addresses are to be retrieved.
     * @return A list of Address records associated with the provided userId.
     */
    List<Address> findByUserId(Long userId);
}
