package com.hyon.oct1212.fruit;

import java.util.List;

import com.hyon.oct1212.fruit.Fruit;

public interface FruitMapper {
  public List<Fruit> getAllFruits();
  
  public List<Fruit> getPriceFruit(Fruit f);  
  
}