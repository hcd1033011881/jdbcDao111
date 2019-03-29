import com.kgc.news.impl.NewsDaoImpl;
import com.kgc.news.pojo.NewsDetails;

/**
 * @author Mr.5227
 * @date 2019/3/20 - 11:05
 */
public class test {
    public static void main(String[] args) {
        NewsDaoImpl nsi = new NewsDaoImpl();
        NewsDetails news = new NewsDetails();


        //查询数据
/*            List<NewsDetails> list =  nsi.getNewsDetails();
            for (NewsDetails newsDetails : list) {
                System.out.println(newsDetails.getId()+"\n"+newsDetails.getTitle()+"\n"+newsDetails.getCategoryId()
                        +"\n"+newsDetails.getContent()+"\n"+newsDetails.getCreateDate());
            }*/
        //插入数据
/*        news.setId(99);
        news.setTitle("课工场");
        news.setAuthor("hcd");
        news.setCreateDate(new Date());
        nsi.addNews(news);*/
        //修改数据
//        news.setId(88);
//        nsi.updateNews(news);
        //删除数据
        news.setId(88);
        nsi.deleteNews(news);

    }
}
