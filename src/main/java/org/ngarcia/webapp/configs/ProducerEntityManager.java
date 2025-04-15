package org.ngarcia.webapp.configs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@RequestScoped
public class ProducerEntityManager {

   //el nombre está en persistence.xml
   @PersistenceContext(name="ejemploJPA")
   private EntityManager em;

   @Produces
   @RequestScoped
   private EntityManager beanEntityManager() {
      return em;
   }

}