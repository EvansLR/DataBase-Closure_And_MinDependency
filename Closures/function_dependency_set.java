
import java.util.*;

// 函数依赖集类
public class function_dependency_set {
    ArrayList<function_dependency>fds;
    // 构造函数初始化
    public function_dependency_set(){
        fds=new ArrayList<function_dependency>();
    }

    // 获取指定位置的函数依赖
    public function_dependency get_item(int index){
        return fds.get(index);
    }

    // 将函数依赖集转换为字符串
    public String toString(){
        String res[]=new String[fds.size()];
        for (int i=0;i<fds.size();i++){
            res[i]=fds.get(i).toString();
        }
        // 对依赖集进行排序
        Arrays.sort(res);
        // 转换为最终字符串
        String f_res="{";
        for (int j=0;j<fds.size();j++){
            f_res+=(res[j]+",");
        }
        f_res=f_res.substring(0,f_res.length()-1);
        
        f_res+="}";

        return f_res;

    }

    // 判断两个函数依赖集是否相同
    public boolean is_equal(function_dependency_set a){
        // 假如字符串比较相同
        if (a.toString().equals(this.toString())){
            return true;
        }
        return false;
    }
    // 增加一个函数依赖
    public void append(function_dependency fd){
        fds.add(fd);
    }
    // 删除一个函数依赖
    public void remove(function_dependency fd){
        this.fds.remove(fd);
    }

    // 获取索引
    public int  index(function_dependency fd){
        return this.fds.indexOf(fd);
    }

    // 获取函数依赖集
    public ArrayList<function_dependency> get_Function_dependency_set(){
        return this.fds;
    }

    // 获取依赖集的长度
    public int count(){
        return this.fds.size();
    }

    // 复制一个函数依赖集
    public function_dependency_set clone() {
        function_dependency_set a= new function_dependency_set();
        a.fds=new ArrayList<function_dependency>(this.fds);
        return a;
    }

    // 将函数依赖集的每个右半部分分裂开
    public void right_split()
    {
        // 保存需要删除的
        ArrayList<function_dependency> del_list=new ArrayList<function_dependency>();
       
        // 保存需要添加的
        ArrayList<function_dependency> add_list=new ArrayList<function_dependency>();
        
        for (int i=0;i<fds.size();i++){
            function_dependency f=fds.get(i);
            // 对右半部分进行分割
            ArrayList<function_dependency>r=f.right_split();
            // 假如为空
            if (r.size()==0){
                continue;
            }
            else{
                del_list.add(f);
                for (int j=0;j<r.size();j++){
                    // 拆分后加入函数依赖
                    add_list.add(r.get(j));
                }
            }


        }

        // 将删除部分的全部删除
        for (int i=0;i<del_list.size();i++){
            this.fds.remove(del_list.get(i));
        }
        // 将添加部分全部添加
        for (int i=0;i<add_list.size();i++){
            this.fds.add(add_list.get(i));
        }
        // 对函数依赖进行排序
        this.fds.sort(new SortByIndex2());
    }
    

    // 将函数依赖集的左半部分裂开
    public void left_split()
    {
        // 保存需要删除的
        ArrayList<function_dependency> del_list=new ArrayList<function_dependency>();
       
        // 保存需要添加的
        ArrayList<function_dependency> add_list=new ArrayList<function_dependency>();
        
        for (int i=0;i<fds.size();i++){
            function_dependency f=fds.get(i);
            // 对左半部分进行分割
            ArrayList<function_dependency>r=f.left_split();
            // 假如为空
            if (r.size()==0){
                continue;
            }
            else{
                del_list.add(f);
                for (int j=0;j<r.size();j++){
                    // 拆分后加入函数依赖
                    add_list.add(r.get(j));
                }
            }


        }

        // 将删除部分的全部删除
        for (int i=0;i<del_list.size();i++){
            this.fds.remove(del_list.get(i));
        }
        // 将添加部分全部添加
        for (int i=0;i<add_list.size();i++){
            this.fds.add(add_list.get(i));
        }
        // 对函数依赖进行排序
        this.fds.sort(new SortByIndex2());
    }



}
