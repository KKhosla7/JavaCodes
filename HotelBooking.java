public boolean Hotel(ArrayList<Integer> arrive,ArrayList<Integer> depart, int K)
       {
              int i=0;
              int j=0;
              int counter=0;
              Collections.sort(arrive);
              Collections.sort(depart);
              

              while(i<arrive.size()&&j<depart.size())
              {
                     if(arrive.get(i)<depart.get(j))
                     {
                           i++;
                           counter++;
                     }
                     else
                     {
                           j++;
                           counter--;
                           
                     }
                     if(counter>K)
                           return false;
              
              }
              System.out.println("Arrive : "+arrive);
              System.out.println("Depart : "+depart);
              System.out.println(counter);
              //int leftOver=depart.size()-1-j;
              //maxCounter=maxCounter+leftOver;

              if(counter>K)
                     return false;
              else 
                     return true;
       }
