/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mfedu.trainerspringboot.services;

import java.util.List;
import org.mfedu.trainerspringboot.entities.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mac
 */

@Service("trainerService")
@Transactional
public class TrainerImpl{

    @Autowired
	private TrainerRepository repo;;
	
	public List<Trainer> listAll() {
		return repo.findAll();
	}
	
	public void save(Trainer trainer) {
		repo.save(trainer);
	}
	
	public Trainer get(int id) {
		return repo.findById(id).get();
	}
	
	public void delete(int id) {
		repo.deleteById(id);
	}
        public Trainer getOne(int id){
            return repo.getOne(id);
        }

}
