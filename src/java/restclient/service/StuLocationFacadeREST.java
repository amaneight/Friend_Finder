/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import restclient.StuLocation;

/**
 *
 * @author Dangerlal
 */
@Stateless
@Path("restclient.stulocation")
public class StuLocationFacadeREST extends AbstractFacade<StuLocation> {

    @PersistenceContext(unitName = "FIT5046Assign1PU")
    private EntityManager em;

    public StuLocationFacadeREST() {
        super(StuLocation.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StuLocation entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, StuLocation entity) {
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
    public StuLocation find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuLocation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuLocation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //Get location by locLat
    @GET
    @Path("findByLocLat/{locLat}")
    @Produces({"application/json"})
    public List<StuLocation> findByLocLat(@PathParam("locLat") Double locLat){
        Query query = em.createNamedQuery("StuLocation.findByLocLat");
        query.setParameter("locLat", locLat);
        return query.getResultList();
    }
    
    //Get location by locLon
    @GET
    @Path("findByLocLon/{locLon}")
    @Produces({"application/json"})
    public List<StuLocation> findByLocLon(@PathParam("locLon") Double locLon){
        Query query = em.createNamedQuery("StuLocation.findByLocLon");
        query.setParameter("locLon", locLon);
        return query.getResultList();
    }
    
    //Get location by locDate
    @GET
    @Path("findByLocDate/{locDate}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocDate(@PathParam("locDate") Date locDate){
        Query query = em.createNamedQuery("StuLocation.findByLocDate");
        query.setParameter("locDate", locDate);
        return query.getResultList();
    }
    
    //Get location by locTime
    @GET
    @Path("findByLocTime/{locTime}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocTime(@PathParam("locTime") Date locTime){
        Query query = em.createNamedQuery("StuLocation.findByLocTime");
        query.setParameter("locTime", locTime);
        return query.getResultList();
    }
    
    //Get location by locName
    @GET
    @Path("findByLocName/{locName}")
    @Produces({"application/json"})
    public List<StuLocation> findBylocName(@PathParam("locName") String locName){
        Query query = em.createNamedQuery("StuLocation.findByLocName");
        query.setParameter("locName", locName);
        return query.getResultList();
    }
        
    //Task 2)- b)3
    //Get student profile by Gender, Favorite Movie and Location
    @GET
    @Path("findByGenderFMovieANDLocation/{stuGender}/{stuFavMovie}/{locName}")
    @Produces({"application/json"})
    public List<StuLocation> findByGenderFMovieANDLocation(@PathParam("stuGender") String stuGender, 
            @PathParam("stuFavMovie") String stuFavMovie, @PathParam("locName") String locName) throws ParseException{
        
        TypedQuery<StuLocation> query = em.createQuery("SELECT l FROM StuLocation l WHERE l.stuId.stuGender = :stuGender AND l.stuId.stuFavMovie = :stuFavMovie AND l.locName = :locName " ,StuLocation.class);
        query.setParameter("stuGender", stuGender);
        query.setParameter("stuFavMovie", stuFavMovie);
        query.setParameter("locName", locName);
        return query.getResultList();
    }
   
    //Task 2)- b)4
    //Get student profile by Gender, Favorite Movie and Location
    @GET
    @Path("findByLocNameANDFavSport/{locName}/{stuFavSport}")
    @Produces({"application/json"})
    public List<StuLocation> findByLocNameANDFavSport( @PathParam("locName") String locName, @PathParam("stuFavSport") String stuFavSport) throws ParseException{
        
        Query query = em.createNamedQuery("StuLocation.findByLocNameANDFavSport");
        query.setParameter("locName", locName);
        query.setParameter("stuFavSport", stuFavSport);
        return query.getResultList();
    }
    
    //Task 2)- b)4
    //Get student profile by Gender, Favorite Movie and Location
    @GET
    @Path("listByStDateEnDateANDStuId/{stDate}/{enDate}/{stuId}")
    @Produces({"application/json"})
    public List<String> listByStDateEnDateANDStuId( @PathParam("stDate") String stDate, @PathParam("enDate") String enDate, @PathParam("stuId") String stuId) throws ParseException{
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        Date sDate = df.parse(stDate);
        Date eDate = df.parse(enDate);
        Query l = em.createQuery("SELECT s.locName, COUNT(s) FROM StuLocation s WHERE s.locDate >= :stDate AND s.locDate >= :enDate AND s.stuId.stuId = :stuId GROUP BY s.locName");
        TypedQuery<StuLocation> query = em.createQuery("SELECT s FROM StuLocation s WHERE s.locDate >= :stDate AND s.locDate >= :enDate AND s.stuId.stuId = :stuId", StuLocation.class);
        
        l.setParameter("stDate", sDate);
        l.setParameter("enDate", eDate);
        l.setParameter("stuId", stuId);
        List<String> t= l.getResultList();
        return t;
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    
}
