/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restclient.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONException;
import restclient.LocationCount;
import restclient.StuProfile;
import restclient.UnitCount;

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
        
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh24:mm:ss");
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
    
    
    //Task 3)- c)
    //Get future friends on the basis of suburb, fav unit and fav sport
    @GET
    @Path("searchFutureFriends_1/{stuId}/{stuSuburb}/{stuFavUnit}/{stuFavSport}")
    @Produces({"application/json"})
    public List<StuProfile> searchFutureFriends_1(@PathParam("stuId") String stuId,
            @PathParam("stuSuburb") String stuSuburb,
            @PathParam("stuFavUnit") String stuFavUnit,
            @PathParam("stuFavSport") String stuFavSport){
        
        //Fetch all students
        TypedQuery<StuProfile> queryAllStudents = em.createQuery("SELECT s FROM StuProfile s",StuProfile.class);
        List<StuProfile> allStudents = queryAllStudents.getResultList();
        
        //Fetch students who are friends with given student ID
        TypedQuery<StuProfile> queryFriend = em.createQuery("SELECT f.frFriendId FROM StuFriendship f WHERE f.frStuId.stuId = :stuId UNION "
                + "SELECT f.frStuId FROM StuFriendship f WHERE f.frFriendId.stuId = :stuId", StuProfile.class);
        queryFriend.setParameter("stuId", stuId);
        
        List<StuProfile> friendsList = queryFriend.getResultList();
        List<StuProfile> futureFriendsList = new ArrayList<StuProfile>();
        
        //Remove students who are friends with given student ID
        allStudents.removeAll(friendsList); 
        
        TypedQuery<StuProfile> queryFutureFriend;
        
        for(int i = 0;i < allStudents.size(); i++){
            StuProfile s = allStudents.get(i);
            
            //Find future friends with same interests
            queryFutureFriend = em.createQuery(
                    "SELECT s FROM StuProfile s WHERE s.stuId = :stuId AND s.stuSuburb = :stuSuburb AND "
                            + "s.stuFavUnit = :stuFavUnit AND s.stuFavSport = :stuFavSport" ,StuProfile.class
            );
            
            queryFutureFriend.setParameter("stuId",s.getStuId() );
            queryFutureFriend.setParameter("stuSuburb", stuSuburb);
            queryFutureFriend.setParameter("stuFavUnit", stuFavUnit);
            queryFutureFriend.setParameter("stuFavSport", stuFavSport);
            List<StuProfile> qResult = queryFutureFriend.getResultList();
            if(qResult.size() > 0){
                futureFriendsList.add(qResult.get(0));
            }
            
        }
        return futureFriendsList;
    }

    //Task 3)- d)
    //Get future friends on the basis of any number of parameters    
    @GET
    @Path("/searchFutureFriends")
    @Produces({"application/json"})
    public List<StuProfile> searchFutureFriends(
    @QueryParam("stuFname") String stuFname,
    @QueryParam("stuLname") String stuLname,
    @QueryParam("stuGender") String stuGender,
    @QueryParam("stuDob") String stuDob,
    @QueryParam("stuCourse") String stuCourse,
    @QueryParam("stuAddress") String stuAddress,
    @QueryParam("stuNationality") String stuNationality,
    @QueryParam("stuNativeLang") String stuNativeLang,
    @QueryParam("stuFavSport") String stuFavSport,
    @QueryParam("stuFavMovie") String stuFavMovie,
    @QueryParam("stuFavUnit") String stuFavUnit,
    @QueryParam("stuCurrJob") String stuCurrJob,
    @QueryParam("stuSubDate") String stuSubDate,
    @QueryParam("stuSubTime") String stuSubTime,
    @QueryParam("stuId") String stuId) throws ParseException{
        
        //Fetch all students
        TypedQuery<StuProfile> queryAllStudents = em.createQuery("SELECT s FROM StuProfile s",StuProfile.class);
        List<StuProfile> allStudents = queryAllStudents.getResultList();
        
        //Fetch students who are friends with given student ID
        TypedQuery<StuProfile> queryFriend = em.createQuery("SELECT f.frFriendId FROM StuFriendship f WHERE f.frStuId.stuId = :stuId UNION "
                + "SELECT f.frStuId FROM StuFriendship f WHERE f.frFriendId.stuId = :stuId", StuProfile.class);
        queryFriend.setParameter("stuId", stuId);
        
        List<StuProfile> friendsList = queryFriend.getResultList();
      
        List<StuProfile> futureFriendsList = new ArrayList<StuProfile>();
        allStudents.removeAll(friendsList); //Remove students who are friends with given student ID
        
        //Create dynamic query
        String query = "SELECT s FROM StuProfile s WHERE ";
        
        HashMap <String, String> hmQueryParams = new HashMap<>();
        
        //Check parameters that have been requested in query
        if(!"".equals(stuFname)){
            query += "s.stuFname = :stuFname AND ";
            hmQueryParams.put("stuFname", stuFname);
        }
        if(!"".equals(stuLname)){
            query += "s.stuLname = :stuLname AND ";
            hmQueryParams.put("stuLname", stuLname);
        }
        if(!"".equals(stuGender)){
            query += "s.stuGender = :stuGender AND ";
            hmQueryParams.put("stuGender", stuGender);
        }
        if(!"".equals(stuDob)){
            query += "s.stuDob = :stuDob AND ";
            hmQueryParams.put("stuDob", stuDob);
        }
        
        if(!"".equals(stuCourse)){
            query += "s.stuCourse = :stuCourse AND ";
            hmQueryParams.put("stuCourse", stuCourse);
        }
        if(!"".equals(stuAddress)){
            query += "s.stuAddress = :stuAddress AND ";
            hmQueryParams.put("stuAddress", stuAddress);
        }
        if(!"".equals(stuNationality)){
            query += "s.stuNationality = :stuNationality AND ";
            hmQueryParams.put("stuNationality", stuNationality);
        }
        if(!"".equals(stuNativeLang)){
            query += "s.stuNativeLang = :stuNativeLang AND ";
            hmQueryParams.put("stuNativeLang", stuNativeLang);
        }
        if(!"".equals(stuFavSport)){
            query += "s.stuFavSport = :stuFavSport AND ";
            hmQueryParams.put("stuFavSport", stuFavSport);
        }
        if(!"".equals(stuFavUnit)){
            query += "s.stuFavUnit = :stuFavUnit AND ";
            hmQueryParams.put("stuFavUnit", stuFavUnit);
        }
        if(!"".equals(stuCurrJob)){
            query += "s.stuCurrJob = :stuCurrJob AND ";
            hmQueryParams.put("stuCurrJob", stuCurrJob);
        }
        if(!"".equals(stuSubDate)){
            query += "s.stuSubDate = :stuSubDate AND ";
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date sDate = df.parse(stuSubDate);
            hmQueryParams.put("stuSubDate", stuSubDate);
        }
        if(!"".equals(stuSubTime)){
            query += "s.stuSubTime = :stuSubTime AND ";
            SimpleDateFormat df = new SimpleDateFormat("HH-mm-ss");
            Date sTime = df.parse(stuSubTime);
            hmQueryParams.put("stuSubTime", stuSubTime);
        }
        query += " s.stuId = :stuId";        

        for(int i = 0;i < allStudents.size(); i++){
            StuProfile s = allStudents.get(i);
           
            //Find future friends with same interests
            TypedQuery<StuProfile>queryFutureFriend= em.createQuery(query,StuProfile.class);
            
            //Add all parameters to the query
            Iterator it = hmQueryParams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry)it.next();
                queryFutureFriend.setParameter((String) pair.getKey(),pair.getValue());
            }
            queryFutureFriend.setParameter("stuId",s.getStuId() );
            
            //Fetch result
            List<StuProfile> qResult = queryFutureFriend.getResultList();
            if(qResult.size() > 0){
                futureFriendsList.add(qResult.get(0));
            }
            
        }
        return futureFriendsList;
        
    };
    
    //Task 3)- e)
    //List all favourite unit and it's frequency
    @GET
    @Path("/listUnitAndFrequency")
    @Produces({"application/json"})
    public List<UnitCount> listUnitAndFrequency( @PathParam("stuFavUnit") String stuFavUnit){
        
        //Get count for all units
        TypedQuery<Object[]> query = em.createQuery("SELECT DISTINCT(s.stuFavUnit), count(s) FROM StuProfile s GROUP BY s.stuFavUnit", Object[].class);
        
        //Convert object array to "custom" class UnitCount list
        List<UnitCount> resultList = new ArrayList<>();
        List<Object[]> unitList = query.getResultList();
        
        for(int i=0; i<unitList.size(); i++) {
            //Extract attributes from object array
            Object[] obj = unitList.get(i);
            String location = (String) obj[0];
            Long count = (Long) obj[1];
            UnitCount lobj = new UnitCount(location, count);
            resultList.add(lobj);
        }
        
        return resultList;
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
