/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfedu.trainerspringboot.services;

import org.mfedu.trainerspringboot.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maih_sofi
 */
public interface TrainerRepository extends JpaRepository<Trainer, Integer>{
    
}
