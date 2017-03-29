/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restclient.StuFriendship;
import restclient.StuProfile;

/**
 *
 * @author Dangerlal
 */
@Stateless
@Path("restclient.stufriendship")
public class StuFriendshipFacadeREST extends AbstractFacade<StuFriendship> {

    @PersistenceContext(unitName = "FIT5046Assign1PU")
    private EntityManager em;

    public StuFriendshipFacadeREST() {
        super(StuFriendship.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StuFriendship entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StuFriendship entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public StuFriendship find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuFriendship> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuFriendship> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    //Get friend profile by friend id
    @GET
    @Path("findByFrId/{frId}")
    @Produces({"application/json"})
    public List<StuProfile> findByFrId(@PathParam("frId") String frId){
        Query query = em.createNamedQuery("StuFriendship.findByFrId");
        query.setParameter("frId", frId);
        return query.getResultList();
    }

    //Get friend profile by friendship start date
    @GET
    @Path("findByFrStartDate/{frStartDate}")
    @Produces({"application/json"})
    public List<StuProfile> findByFrStartDate(@PathParam("frStartDate") Date frStartDate){
        Query query = em.createNamedQuery("StuFriendship.findByFrStartDate");
        query.setParameter("frStartDate", frStartDate);
        return query.getResultList();
    }    
    
    //Get friend profile by friendship start date
    @GET
    @Path("findByFrEndDate/{frEndDate}")
    @Produces({"application/json"})
    public List<StuProfile> findByFrEndDate(@PathParam("frEndDate") Date frEndDate){
        Query query = em.createNamedQuery("StuFriendship.findByFrEndDate");
        query.setParameter("frEndDate", frEndDate);
        return query.getResultList();
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
  
}
