import java.util.Comparator;
import java.util.Objects;

public class Attribute
{
   private String name;


    // 初始化构造函数
   public Attribute(String name){
       this.name=name;
   }

    // 获取属性
    public String get_name(){
        return this.name;
    }

    // 获取属性hash
    public int get_hash(){
        return this.name.hashCode();
    }

    // 比较属性值 相等
    public boolean is_equal(Attribute other){
        return this.name.equals(other.get_name());
    }
    public boolean not_equal(Attribute other){

        return !this.name.equals(other.get_name());
    }

    // 比较属性值的大小关系
    public boolean less_than(Attribute other){

        if (this.name.compareTo(other.get_name())<0)
        {
          return true;
        }
        return false;
    }
    public boolean greater_than(Attribute other){

        if (this.name.compareTo(other.get_name())>0)
        {
          return true;
        }
        return false;
    }

    // 复制一个属性
    public Attribute clone(){
        return new Attribute(this.name);
    }


    // 重写相等判断
    @Override
    public boolean equals(Object o) {
        //自反性
        if (this == o) return true;
        //任何对象不等于null，比较是否为同一类型
        if (!(o instanceof Attribute)) return false;
        //强制类型转换
        Attribute a = (Attribute) o;
        //比较属性值,即可重写方法
        return a.get_name().equals(this.name);
    }


    // 重写hash方法
    @Override
    public int hashCode() {
        return Objects.hash(get_name());
    }






}
    // 根据string进行排序
class SortByIndex implements Comparator<Attribute> 
{
      @Override
        public int compare(Attribute o1, Attribute o2) 
        {
            return o1.get_name().compareTo(o2.get_name());
    }

}