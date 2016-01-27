package com.bigBrain.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bigBrain.entity.Word;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("big_brain");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

		try{
			tx.begin();

			Word word = em.find(Word.class, "sejoong");

			model.addAttribute("message", "I am " + word);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}

		emf.close();

		return "hello";
	}
}