package trees;



public class TreeTest<T>{


	public TreeTest(StandardBinaryTree<String> test) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args){
	StandardBinaryTree<String> test=new StandardBinaryTree<String>();
	
	TreePrinter<String> printer=new TreePrinter<String>(test);
	Position<String> p1=test.addRoot("Sidney");
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p2=test.insertLeft(p1, "Coral");
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p3=test.insertLeft(p2, "Ian");
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p4= test.insertRight(p2, "Rem"); 
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p5= test.insertLeft(p3, "Kirsty");
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p6=test.insertLeft(p4, "Coral"); 
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	Position<String> p7= test.insertRight(p4, "Alan"); 
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	test.remove(p7); 
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	p7 = test.insertRight(p4, "Tanya");
	printer.visit(p1,2);
	System.out.println(printer.toString());
	printer.cleaner();
	test.remove(p1); 
	printer.visit(p2,2);
	System.out.println(printer.toString());
				//System.out.println(printer.toString());
				
				
				//System.out.println(printer.toString());
				//printer.visit(p,null);
	}
}
