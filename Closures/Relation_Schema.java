import java.util.*;

public class Relation_Schema
{
    function_dependency_set fd_set;
    Attribute_Set a_set;
    public Relation_Schema(){
        fd_set=new function_dependency_set();
        a_set=new Attribute_Set();

    }
    

    // 转换为字符串
    public String toString(){
        String res="U=";
        res+=this.a_set.toString();
        res+="\n";
        res+="F=";
        res+=this.fd_set.toString();
        return res;
    }

    // 获取属性集
    public Attribute_Set get_Attribute_Set(){
        return this.a_set;
    }
    // 获取函数依赖；
    public function_dependency_set get_Function_dependency_set(){
        return this.fd_set;
    }

    // 添加属性
    public void add_attribute(Attribute a){

        this.a_set.append(a);
    }

    // 添加函数依赖
    public void add_function_dependency(function_dependency a){
        this.fd_set.append(a);
    }

    // 在关系模式rs中，求属性集a_set关于F的闭包
    public  Attribute_Set get_closure_of_attribute_set(function_dependency_set fd_set,Attribute_Set a_set,Attribute_Set u_set){
        ArrayList<function_dependency>fds=new  ArrayList<function_dependency>(fd_set.get_Function_dependency_set());
        // 假如是全集的子集
        if (a_set.is_subset(u_set))
        {
            // 新建两个属性集合
            Attribute_Set a=new Attribute_Set();
            a.copy(a_set);
            Attribute_Set b=new Attribute_Set();
            
            while (true)

            {
                Attribute_Set t= new Attribute_Set();
                // 保存要删除的函数依赖
                ArrayList<function_dependency>dels=new ArrayList<function_dependency>();
                // 依次取函数依赖的左部，判断左部是否为a_set子集
                for (int i=0;i<fds.size();i++){
                    function_dependency f=fds.get(i);
                    Attribute_Set las=f.get_left_Attribute_Set();
                    // 假如是它的子集
                    if (las.is_subset(a)){
                        t.append_list(f.get_right_Attribute_Group());
                        dels.add(f);
                    }
                }
                // 删除要删除的函数依赖
                for(int j=0;j<dels.size();j++){
                    // 删除相应位置的函数依赖
                    fds.remove(dels.get(j));
                }
                b=a.clone();
                // 或运算
                a=a.or_(t);
                if (a.attributes.toString().equals(b.attributes.toString())||a.attributes.toString().equals(u_set.attributes.toString())){
                    break;
                }

            }
            a.sort();
            return a;

        }
        // 不满足直接返回全集
        else{
        return a_set;
        }


    }

    // 求关系模式中F的最小覆盖
    public function_dependency_set get_canonical_cover(Relation_Schema rs){
    //    对右半部分进行分割
        rs.get_Function_dependency_set().right_split();
        // 获取属性全集
        Attribute_Set u=rs.get_Attribute_Set();
        // 获取函数依赖集
        function_dependency_set fds=rs.get_Function_dependency_set();
        // 复制函数依赖
        function_dependency_set g=fds.clone();
        // 获取数目
        int c=fds.count();


        // 按照数目进行迭代
        for(int i=0;i<c;i++){
            // 获取对应位置的函数依赖
            function_dependency f=fds.get_item(i);
            // 删除这个函数依赖
            g.remove(f);
           
            // 计算闭包
            Attribute_Set cat=rs.get_closure_of_attribute_set(g,f.get_left_Attribute_Set(),u);
            
            // 判断子集
            Attribute_Set f_right=f.get_right_Attribute_Set();
            if (f_right.is_subset(cat))continue;
            else{
                g.append(f);
            }
        }

        // 处理左边的冗余属性
        rs.get_Function_dependency_set().left_split();;
        // 获取函数依赖集
        fds=rs.get_Function_dependency_set();
        // 复制函数依赖
        g=fds.clone();
        // 获取数目
        c=fds.count();
        // 按照数目进行迭代
        for(int i=0;i<c;i++){
            // 获取对应位置的函数依赖
            function_dependency f=fds.get_item(i);
            // 删除这个函数依赖
            g.remove(f);
           
            // 计算闭包
            Attribute_Set cat=rs.get_closure_of_attribute_set(g,f.get_left_Attribute_Set(),u);
            
            // 判断子集
            Attribute_Set f_right=f.get_right_Attribute_Set();
            if (f_right.is_subset(cat))continue;
            else{
                g.append(f);
            }
        }

        return g;
    
    }


}
