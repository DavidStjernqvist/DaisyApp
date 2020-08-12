package com.company.daisyapp.Repositories;

import com.company.daisyapp.Models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Integer> {
}
