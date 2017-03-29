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
import restclient.StuProfile;

/**
 *
 * @author Dangerlal
 */
@Stateless
@Path("restclient.stuprofile")
public class StuProfileFacadeREST extends AbstractFacade<StuProfile> {

    @PersistenceContext(unitName = "FIT5046Assign1PU")
    private EntityManager em;

    public StuProfileFacadeREST() {
        super(StuProfile.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(StuProfile entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, StuProfile entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public StuProfile find(@PathParam("id") String id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuProfile> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<StuProfile> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    
    //Get student profile by first name
    @GET
    @Path("findByStuFname/{stuFname}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuFname(@PathParam("stuFname") String stuFname){
        Query query = em.createNamedQuery("StuProfile.findByStuFname");
        query.setParameter("stuFname", stuFname);
        return query.getResultList();
    }
    
    //Get student profile by last name
    @GET
    @Path("findByStuLname/{stuLname}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuLname(@PathParam("stuLname") String stuLname){
        Query query = em.createNamedQuery("StuProfile.findByStuLname");
        query.setParameter("stuLname", stuLname);
        return query.getResultList();
    }
    
    //Get student profile by DOB
    @GET
    @Path("findByStuDob/{stuDob}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuDob(@PathParam("stuDob") String stuDob){
        Query query = em.createNamedQuery("StuProfile.findByStuDob");
        query.setParameter("stuDob", stuDob);
        return query.getResultList();
    }
    
    //Get student profile by Gender
    @GET
    @Path("findByStuGender/{stuGender}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuGender(@PathParam("stuGender") String stuGender){
        Query query = em.createNamedQuery("StuProfile.findByStuGender");
        query.setParameter("stuGender", stuGender);
        return query.getResultList();
    }
    
    //Get student profile by Course
    @GET
    @Path("findByStuCourse/{stuCourse}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuCourse(@PathParam("stuCourse") String stuCourse){
        Query query = em.createNamedQuery("StuProfile.findByStuCourse");
        query.setParameter("stuCourse", stuCourse);
        return query.getResultList();
    }
    
    //Get student profile by Address
    @GET
    @Path("findByStuAddress/{stuAddress}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuAddress(@PathParam("stuAddress") String stuAddress){
        Query query = em.createNamedQuery("StuProfile.findByStuAddress");
        query.setParameter("stuAddress", stuAddress);
        return query.getResultList();
    }
    
    //Get student profile by Suburb
    @GET
    @Path("findByStuSuburb/{stuSuburb}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuSuburb(@PathParam("stuSuburb") String stuSuburb){
        Query query = em.createNamedQuery("StuProfile.findByStuSuburb");
        query.setParameter("stuSuburb", stuSuburb);
        return query.getResultList();
    }
    
    //Get student profile by Nationality
    @GET
    @Path("findByStuNationality/{stuNationality}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuNationality(@PathParam("stuNationality") String stuNationality){
        Query query = em.createNamedQuery("StuProfile.findByStuNationality");
        query.setParameter("stuNationality", stuNationality);
        return query.getResultList();
    }
    
    //Get student profile by NativeLang
    @GET
    @Path("findByStuNativeLang/{stuNativeLang}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuNativeLang(@PathParam("stuNativeLang") String stuNativeLang){
        Query query = em.createNamedQuery("StuProfile.findByStuNativeLang");
        query.setParameter("stuNativeLang", stuNativeLang);
        return query.getResultList();
    }
    
    //Get student profile by FavSport
    @GET
    @Path("findByStuFavSport/{stuFavSport}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuFavSport(@PathParam("stuFavSport") String stuFavSport){
        Query query = em.createNamedQuery("StuProfile.findByStuFavSport");
        query.setParameter("stuFavSport", stuFavSport);
        return query.getResultList();
    }
    
    //Get student profile by FavMovie
    @GET
    @Path("findByStuFavMovie/{stuFavMovie}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuFavMovie(@PathParam("stuFavMovie") String stuFavMovie){
        Query query = em.createNamedQuery("StuProfile.findByStuCourse");
        query.setParameter("stuFavMovie", stuFavMovie);
        return query.getResultList();
    }
    
    //Get student profile by FavUnit
    @GET
    @Path("findByStuFavUnit/{stuFavUnit}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuFavUnit(@PathParam("stuFavUnit") String stuFavUnit){
        Query query = em.createNamedQuery("StuProfile.findByStuFavUnit");
        query.setParameter("stuFavUnit", stuFavUnit);
        return query.getResultList();
    }
    
    //Get student profile by CurrJob
    @GET
    @Path("findByStuCurrJob/{stuCurrJob}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuCurrJob(@PathParam("stuCurrJob") String stuCurrJob){
        Query query = em.createNamedQuery("StuProfile.findByStuCurrJob");
        query.setParameter("stuCurrJob", stuCurrJob);
        return query.getResultList();
    }
    
    //Get student profile by UniEmail
    @GET
    @Path("findByStuUniEmail/{stuUniEmail}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuUniEmail(@PathParam("stuUniEmail") String stuUniEmail){
        Query query = em.createNamedQuery("StuProfile.findByUniEmail");
        query.setParameter("stuUniEmail", stuUniEmail);
        return query.getResultList();
    }
    
    //Get student profile by UniPassword
    @GET
    @Path("findByStuUniPassword/{stuUniPassword}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuUniPassword(@PathParam("stuUniPassword") String stuUniPassword){
        Query query = em.createNamedQuery("StuProfile.findByStuUniPassword");
        query.setParameter("stuUniPassword", stuUniPassword);
        return query.getResultList();
    }
    
    //Get student profile by SubDate
    @GET
    @Path("findByStuSubDate/{stuSubDate}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuSubDate(@PathParam("stuSubDate") String stuSubDate) throws ParseException{
        Query query = em.createNamedQuery("StuProfile.findByStuSubDate");
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(stuSubDate);
                
        query.setParameter("stuSubDate", date);
        return query.getResultList();
    }
    
    //Get student profile by SubTIme
    @GET
    @Path("findByStuSubTime/{stuSubTime}")
    @Produces({"application/json"})
    public List<StuProfile> findByStuSubTime(@PathParam("stuSubTime") String stuSubTime) throws ParseException{
        Query query = em.createNamedQuery("StuProfile.findByStuSubTime");
        
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date date = df.parse(stuSubTime);

        query.setParameter("stuSubTime", date);
        return query.getResultList();
    }

    //Task 2)- b)2
    //Get student profile by First Name and Last Name
    @GET
    @Path("findByFNameANDLName/{stuFname}/{stuLname}")
    @Produces({"application/json"})
    public List<StuProfile> findByFNameANDLName(@PathParam("stuFname") String stuFname, 
            @PathParam("stuLname") String stuLname) throws ParseException{
        
        TypedQuery<StuProfile> query = em.createQuery("SELECT s FROM StuProfile s WHERE s.stuFname = :stuFname AND s.stuLname = :stuLname",StuProfile.class);
        query.setParameter("stuFname", stuFname);
        query.setParameter("stuLname", stuLname);
        return query.getResultList();
    }
    

    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
