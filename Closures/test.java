public class test {
    public static void main(String[] args) {
        // Relation_Schema rs = new Relation_Schema();
        // // A, B, C, D, E
        // rs.add_attribute(new Attribute("A"));
        // rs.add_attribute(new Attribute("B"));
        // rs.add_attribute(new Attribute("C"));
        // rs.add_attribute(new Attribute("D"));
        // rs.add_attribute(new Attribute("E"));
        // // AB→C, B→D, C→E, EC→B, AC→B
        // Attribute_Group gl =new Attribute_Group();
        // gl.append(new Attribute("A"));
        // gl.append(new Attribute("B"));
        // Attribute_Group gr = new Attribute_Group();
        // gr.append(new Attribute("C"));
        // function_dependency f = new function_dependency(gl, gr);
        // rs.add_function_dependency(f);
        // // B->D
        // gl =new Attribute_Group();
        // gl.append(new Attribute("B"));
        // gr = new Attribute_Group();
        // gr.append(new Attribute("D"));
        // f = new function_dependency(gl, gr);
        // rs.add_function_dependency(f);

        // // C->E
        // gl =new Attribute_Group();
        // gl.append(new Attribute("C"));
        // gr = new Attribute_Group();
        // gr.append(new Attribute("E"));
        // f = new function_dependency(gl, gr);
        // rs.add_function_dependency(f);

        // //  EC->B
        // gl =new Attribute_Group();
        // gl.append(new Attribute("E"));
        // gl.append(new Attribute("C"));
        // gr = new Attribute_Group();
        // gr.append(new Attribute("B"));
        // f = new function_dependency(gl, gr);
        // rs.add_function_dependency(f);

        // // AC->B
        // gl =new Attribute_Group();
        // gl.append(new Attribute("A"));
        // gl.append(new Attribute("C"));
        // gr = new Attribute_Group();
        // gr.append(new Attribute("B"));
        // f = new function_dependency(gl, gr);
        // rs.add_function_dependency(f);
        
        // System.out.println(" ");
        // System.out.println(rs.toString());
        // // 求(AB)F+
        // Attribute_Set a =new Attribute_Set();
        // a.append(new Attribute("A"));
        // a.append(new Attribute("B"));
        // Attribute_Set res=rs.get_closure_of_attribute_set(rs.fd_set, a, rs.a_set);
        // System.out.println(res.toString());


        // 测试闭包
        test_a mytTest_a=new test_a();
        mytTest_a.closure_test2();
        // 测试最小覆盖
        mytTest_a.cover();
        mytTest_a.cover2();

        
    }
    
}
class test_a{
    public void closure_test(){
        Relation_Schema rs = new Relation_Schema();
        // A, B, C, D, E
        rs.add_attribute(new Attribute("A"));
        rs.add_attribute(new Attribute("B"));
        rs.add_attribute(new Attribute("C"));
        rs.add_attribute(new Attribute("D"));
        rs.add_attribute(new Attribute("E"));
        // AB→C, B→D, C→E, EC→B, AC→B
        Attribute_Group gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gl.append(new Attribute("B"));
        Attribute_Group gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        function_dependency f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        // B->D
        gl =new Attribute_Group();
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("D"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // C->E
        gl =new Attribute_Group();
        gl.append(new Attribute("C"));
        gr = new Attribute_Group();
        gr.append(new Attribute("E"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        //  EC->B
        gl =new Attribute_Group();
        gl.append(new Attribute("E"));
        gl.append(new Attribute("C"));
        gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // AC->B
        gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gl.append(new Attribute("C"));
        gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        
        System.out.println(" ");
        System.out.println(rs.toString());
        // 求(AB)F+
        Attribute_Set a =new Attribute_Set();
        a.append(new Attribute("A"));
        a.append(new Attribute("B"));
        Attribute_Set res=rs.get_closure_of_attribute_set(rs.fd_set, a, rs.a_set);
        System.out.println("(AB)F+为");
        System.out.println(res.toString());
    }

    public void closure_test2(){
        Relation_Schema rs = new Relation_Schema();
        // A, B, C, G ,H,I
        rs.add_attribute(new Attribute("A"));
        rs.add_attribute(new Attribute("B"));
        rs.add_attribute(new Attribute("C"));
        rs.add_attribute(new Attribute("G"));
        rs.add_attribute(new Attribute("H"));
        rs.add_attribute(new Attribute("I"));
        // A→C, A→B, C→E, EC→B, AC→B
        Attribute_Group gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        Attribute_Group gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        function_dependency f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        // A->B
        gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // CG->H
        gl =new Attribute_Group();
        gl.append(new Attribute("C"));
        gl.append(new Attribute("G"));
        gr = new Attribute_Group();
        gr.append(new Attribute("H"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        //  GC->I
        gl =new Attribute_Group();
        gl.append(new Attribute("G"));
        gl.append(new Attribute("C"));
        gr = new Attribute_Group();
        gr.append(new Attribute("I"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // B->H
        gl =new Attribute_Group();
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("H"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        
        System.out.println(" ");
        System.out.println(rs.toString());
        // 求(AB)F+
        Attribute_Set a =new Attribute_Set();
        a.append(new Attribute("A"));
        a.append(new Attribute("G"));
        Attribute_Set res=rs.get_closure_of_attribute_set(rs.fd_set, a, rs.a_set);
        System.out.println("(AG)F+为");
        System.out.println(res.toString());
    }


    public void cover(){
        Relation_Schema rs = new Relation_Schema();
        // A, B, C
        rs.add_attribute(new Attribute("A"));
        rs.add_attribute(new Attribute("B"));
        rs.add_attribute(new Attribute("C"));
        // A→B, B→A, B→C, A→C, C→A
        Attribute_Group gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        Attribute_Group gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        function_dependency f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        // B->A
        gl =new Attribute_Group();
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("A"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // B->C
        gl =new Attribute_Group();
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        //  A->C
        gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // C->A
        gl =new Attribute_Group();
        gl.append(new Attribute("C"));
        gr = new Attribute_Group();
        gr.append(new Attribute("A"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        
        System.out.println(" ");
        System.out.println(rs.toString());
        // 最小依赖
        System.out.println("最小依赖集为");
        System.out.print(rs.get_canonical_cover(rs).toString());
    }

    public void cover2(){
        Relation_Schema rs = new Relation_Schema();
        // A, B, C
        rs.add_attribute(new Attribute("A"));
        rs.add_attribute(new Attribute("B"));
        rs.add_attribute(new Attribute("C"));
        // A→BC, B→C, B→C, A→B, AB→C
        Attribute_Group gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        Attribute_Group gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        gr.append(new Attribute("C"));
        function_dependency f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);
        // B->C
        gl =new Attribute_Group();
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        // A->B
        gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gr = new Attribute_Group();
        gr.append(new Attribute("B"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        //  AB->C
        gl =new Attribute_Group();
        gl.append(new Attribute("A"));
        gl.append(new Attribute("B"));
        gr = new Attribute_Group();
        gr.append(new Attribute("C"));
        f = new function_dependency(gl, gr);
        rs.add_function_dependency(f);

        
        System.out.println(" ");
        System.out.println(rs.toString());
        // 最小依赖
        System.out.println("最小依赖集为");
        System.out.print(rs.get_canonical_cover(rs).toString());
    }
    
}
