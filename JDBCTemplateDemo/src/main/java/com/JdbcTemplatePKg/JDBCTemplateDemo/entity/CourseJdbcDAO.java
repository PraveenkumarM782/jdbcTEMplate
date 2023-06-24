package com.JdbcTemplatePKg.JDBCTemplateDemo.entity;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CourseJdbcDAO.class);
	
	private JdbcTemplate jdbcTemplate;

	public CourseJdbcDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	
        /**
         * Maps a row in the database to a Course
         */
        RowMapper<Course> rowMapper = (rs, rowNum) -> {
            Course course = new Course();
            course.setCourseId(rs.getInt("courseId"));
            course.setTitle(rs.getString("title"));
            course.setDescription(rs.getString("description"));
            course.setLink(rs.getString("link"));
            return course;
        };
        
        public List<Course> getCourseslist() {
            String sql = "SELECT courseId, title, description, link from course";
            return jdbcTemplate.query(sql,rowMapper);
    	}
	 
		 public Optional<Course> getCourse(int id) {
			 Course course=null;
			 String sql = "Select courseId,title,description,link from course where courseId=?";
			 									
		      course = jdbcTemplate.queryForObject(sql,rowMapper ,new Object[] {id});

			 return Optional.ofNullable(course);
		 }
	 
//		 public void create(Course course) {  //this is creating method so it doesn't return any output so thatswhy we write void
//			 String sql = "insert into Course values(?,?,?,?)";
//			 
//			 int output = jdbcTemplate.update(sql, course.getCourseId(),course.getTitle(),course.getDescription(),course.getLink());
//			 
//			 if(output==1)
//			 {
//				 log.info("new course is created ...");
//			 }
//		 }
		 
		 public void update(Course course,int id) {
			 
			 String sql = "update course set title=?,description=?,link=? where courseId=?";
			 
			 int output = jdbcTemplate.update(sql,course.getTitle(),course.getDescription(),course.getLink(),id);
			 
			 if(output==1)
			 {
				 log.info("new course is UPDATED...");
			 }
		 }
		 
		 public void delete(int id) {
			 
			 String sql = "delete from course where courseId=?";
			 
			 int output = jdbcTemplate.update(sql,id);
			 
			 if(output==1)
			 {
				 log.info("new course data is DELETED with id = "+id);
			 }
			 
		 }
		 
}


