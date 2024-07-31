//package com.college.management.system.serviceimp;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//

////@Service
////public class CoursesModelServiceImp implements CoursesModelService{
//
////	@Autowired
////	private CoursesRepository coursesRepository;
////	
////	@Autowired
////	private StreamRepository streamRepository;
////	//private  CoursesModelRepository coursesModelRepository; 
////	@Override
////	public List<CoursesModel> getAllCoursesService() {
//////		this.coursesRepository.findAll().stream().map(courses->{
////			List<CoursesModel> courses=new ArrayList<>();
//////			
//////			coursesModel.setCoursesName(courses.getCourses());
////			
////			List<BtechStream> streamData = this.streamRepository.findAll();
////			streamData.forEach(streams->{
////				CoursesModel coursesModel=new CoursesModel();
////				Courses courses2 = this.coursesRepository.findById(streams.getCoursesId()).get();
////				coursesModel.setCoursesName(courses2.getCourses());
////				coursesModel.setId(courses2.getId());
////				Map<String, String> stream=new HashMap<>();
////				
////				stream.put("streamname", streams.getBTechStream());
////				coursesModel.setStream(stream);
////				courses.add(coursesModel);
////				
////			});
////			return courses;
////			
//////		});
//	//}
//
//
