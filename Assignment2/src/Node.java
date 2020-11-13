public class Node {
   BusBooking info;
   Node left,right;
   Node() {
   }
   Node(BusBooking x) {
     info=x;
     left=right=null;
   }
}
