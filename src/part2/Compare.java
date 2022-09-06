package part2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Compare {
    public static void main(String[] args) {         
        // ArrayList 준비        
        ArrayList<Product> list = new ArrayList<>();        
        list.add(new Product("Galaxy", 2000));        
        list.add(new Product("Apple", 3000));        
        list.add(new Product("Shaomi", 1000));        
        System.out.println("상품 리스트 정렬 전 : " + list); 
        // price순 오름차순으로 정렬        
        Collections.sort(list, new ProductPriceComparator());        
        System.out.println("price 순 오름차순 : " + list); 
        // price순 내림차순으로 정렬        
        Collections.sort(list, new ProductPriceComparator().reversed());        
        System.out.println("price 순 내림차순 : " + list); 
        // name순 오름차순으로 정렬        
        Collections.sort(list, new ProductNameComparator());        
        System.out.println("이름 순 오름차순 : " + list); 
        // name순 내림차순으로 정렬        
        Collections.sort(list, new ProductNameComparator().reversed());        
        System.out.println("이름 순 내림차순 : " + list);
      }

      private static class Product implements Comparable<Product> {
      
        private String name;    
        private int price;     
        
        //VO 개념
        public Product(String name, int price) {        
          this.name = name;        
          this.price = price;    
        }     
        
        @Override    
        public int compareTo(Product product) {        
          if (product.price < price) {            
            return 1;    // 가격 기준으로 상품의 가격 기준
          } 
          else if (product.price > price) {            
            return -1;   // 역순
          }       
          return 0;    
        }    
        
        @Override    
        public String toString() {        
          return "[ " + this.name + ": " + this.price + " ]";    
        }
    }
    
    private static class ProductPriceComparator implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            if(o1.price > o2.price){
                return 1;
            }
            else if(o1.price < o2.price){
                return -1;
            }
            return 0;
        }
    }
    
    private static class ProductNameComparator implements Comparator<Product>{

        @Override
        public int compare(Product o1, Product o2) {
            return o1.name.compareTo(o2.name);
        }

    }
   
}

