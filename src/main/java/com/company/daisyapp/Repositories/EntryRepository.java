package com.company.daisyapp.Repositories;

import com.company.daisyapp.Models.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryRepository extends JpaRepository<Entry,Integer> {
}
