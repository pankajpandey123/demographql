/*
 * package com.company.demographql.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.stereotype.Service;
 * 
 * import com.company.demographql.model.Food; import
 * com.company.demographql.repository.FoodRepository;
 * 
 * import io.leangen.graphql.annotations.GraphQLQuery; import
 * io.leangen.graphql.spqr.spring.annotations.GraphQLApi;
 * 
 * @Service
 * 
 * @GraphQLApi public class FoodService {
 * 
 * private FoodRepository foodRepository;
 * 
 * public FoodService(FoodRepository foodRepository) { this.foodRepository =
 * foodRepository; }
 * 
 * @GraphQLQuery(name = "foods") public List<Food> getFoods() { return
 * foodRepository.findAll(); }
 * 
 * public Food saveFood(Food food) { return foodRepository.save(food); }
 * 
 * }
 */