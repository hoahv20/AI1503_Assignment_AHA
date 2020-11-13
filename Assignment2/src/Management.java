import java.io.*;
public class Management {
    Node root;
    Management() {
     root=null;   
    }
    void clear() {
     root=null;   
    }
    boolean isEmpty() {
     return(root==null);   
    }
    Node search(Node p, String xbcode) {
       if(p==null) return(null);
       if(p.info.getbCode().equals(xbcode)) return(p);
       if(xbcode.compareTo(p.info.getbCode())>0)
           return(search(p.left,xbcode));
         else
           return(search(p.right,xbcode));
    }
    void insert(BusBooking x) {
      if(isEmpty()) {
        root=new Node(x);
        return;
      }
      Node f,p;
      f=null;p=root;
      while(p!=null) {
         if(p.info.getbCode().equals(x.getbCode())) {
             System.out.println("The key " + x.getbCode() + " already exists, no insertion");
             return;
         }
         f=p;
         if(x.getbCode().compareToIgnoreCase(p.info.getbCode()) < 0)
             p=p.left;
           else
             p=p.right;
      }
     if(x.getbCode().compareToIgnoreCase(f.info.getbCode()) < 0) 
        f.left = new Node(x);
        else
         f.right=new Node(x);

    }
    
    void insert1() {
       BusBooking x = new BusBooking("8", "T", 3, 2, 1, 2);
      if(isEmpty()) {
        root=new Node(x);
        return;
      }
      Node f,p;
      f=null;p=root;
      while(p!=null) {
         if(p.info.getbCode().equals(x.getbCode())) {
             System.out.println("The key " + x.getbCode() + " already exists, no insertion");
             return;
         }
         f=p;
         if(x.getbCode().compareToIgnoreCase(p.info.getbCode()) < 0)
             p=p.left;
           else
             p=p.right;
      }
     if(x.getbCode().compareToIgnoreCase(f.info.getbCode()) < 0) 
        f.left = new Node(x);
        else
         f.right=new Node(x);

    }
    
    void insertMany(String [] a,String [] b, int [] c,int [] d, int [] e, int[] f) {
        for(int i=0;i<a.length;i++) insert(new BusBooking(a[i],b[i],c[i],d[i],e[i],f[i]));
    }
    void visit(Node p) {
       System.out.println(p.info);
    }
    void breadth(Node p) {
       if(p==null) return;
       MyQueue q = new MyQueue();
       q.enqueue(p); Node r;
       while(!q.isEmpty()) {
         r=q.dequeue();
         visit(r);
         if(r.left!=null) q.enqueue(r.left);
         if(r.right!=null) q.enqueue(r.right);
       }
    }
    void preOrder(Node p) {
        if(p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    void inOrder(Node p) {
        if(p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void postOrder(Node p) {
        if(p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }

  void loadFile(String fname) throws IOException { // Using FileReader class
   FileReader fr = new FileReader(fname);
   BufferedReader br = new BufferedReader(fr);
   String s; String [] a;
   String xbcode,xname; int xseat,xbooked; int xdepart,xarrival;
   while(true) {
     s = br.readLine();
     if(s==null || s.trim().length()<3) break;
     a = s.split("[|]");
     xbcode = a[0].trim();
     xname = a[1].trim();
     xseat = Integer.parseInt(a[2].trim());
     xbooked = Integer.parseInt(a[3].trim());
     xdepart = Integer.parseInt(a[4].trim());
     xarrival = Integer.parseInt(a[5].trim());
     insert(new BusBooking(xbcode,xname,xseat,xbooked,xdepart,xarrival));
   }
   fr.close();
   br.close();
 }
  void visit(PrintWriter pw, Node p)  throws IOException {
    if(pw==null || p==null) return;
    pw.printf("%10s  |   %10s   |   %5d  |   %5d   |  %5d  |  %5d  \r\n",p.info.getbCode(),p.info.getBus_name(),p.info.getSeat(),p.info.getBooked(),p.info.getDepart_time(),p.info.getArrival_time());
  } 
  void saveFileBreadth(String fname, Node p) throws IOException { // Using FileReader class
    FileWriter fw = new FileWriter(fname);
    PrintWriter pw = new PrintWriter(fw);
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty()) {
       r=q.dequeue();
       visit(pw,r);
       if(r.left!=null) q.enqueue(r.left);
       if(r.right!=null) q.enqueue(r.right);
     }
    pw.close();
    fw.close();
  }

  void deleByCopy(String x) {
    if(isEmpty()) return;
    Node f,p;
    f=null; p=root;
    while(p!=null) {
       if(p.info.equals(x)) break;
       f=p;
       if(x.compareToIgnoreCase(p.info.getbCode()) <0 )
           p=p.left;
         else
           p=p.right;
    }
    if(p==null) return; // not found
    // p is a leaf-node
    if(p.left==null && p.right==null) {
       if(f==null) { // p=root
         root=null;  
       }
       else {
         if(p==f.left)
            f.left=null;
           else
             f.right=null;
       }
       return;
    }
    // p has left son only
    if(p.left!=null && p.right==null) {
       if(f==null) { // p=root
          root=p.left;
       }
       else {
         if(p==f.left)
            f.left=p.left;
           else
             f.right=p.left;
       }
    }
    // p has right son only
    if(p.left==null && p.right!=null) {
       if(f==null) { // p=root
          root=p.right;
       }
       else {
         if(p==f.left)
            f.left=p.right;
           else
             f.right=p.right;
       }
    }
    // p has both 2 sons
    if(p.left!=null && p.right!=null) {
      Node q = p.left;
      Node frp,rp; // rp = right-most node in the left sub-tree
      frp=null;rp=q;
      while(rp.right != null) {
         frp=rp; rp=rp.right;
      }
      // now rp is the right-most node
      p.info=rp.info;
      if(frp==null) {
        p.left = q.left;
      }
      else {
        frp.right=rp.left;
      }
    }  
  }
  
  Node searchByCode(String xCode) {
        Node p = root;
        while (p != null) {
            if (p.info.bCode.equals(xCode)) {
                return (p);
            }
            p = p.right;
        }
        return (null);
    }
  
  void f6() throws IOException{
        clear();
        loadFile("bus.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter code: ");
        String xBcode = bf.readLine();
        Node p = searchByCode(xBcode);
        visit(p);
//        p.info.depart_time = 9;
//        breadth(root);
}
  
  void traverse() {
        Node p = root;
        while (p != null) {
            visit(p);
            p = p.right;
        }
        System.out.println();
    }
  
  void f3() throws IOException {
        clear();
        loadFile("bus.txt");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //System.out.println("Enter code: ");
        //String xBcode = bf.readLine();
        Node p = searchByCode("3");
        remove(p);

    }
  void remove(Node p) {
        if (isEmpty()) {
            return;
        }
        if (p == root) {
            removeFirst();
        }
        Node f = root;
        while (f != null && f.right != p) {
            f = f.right;
        }
        if (f == null) {
            return;
        }
        Node p1 = p.right;
        f.right = p1;
        if (f.right == null) {
            root = f;
        }
    }
  
  void removeFirst() {
        if (isEmpty()) {
            return;
        }
        root = root.right;
        if (root == null) {
            root = null;
        }
    }
}
