import java.util.List;

public class WiseSayingService {

    WiseSayingRepository wiseSayingRepository= new WiseSayingRepository();

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public WiseSaying write(String content, String author){
        WiseSaying wiseSaying=new WiseSaying(author, content);
        WiseSaying savedWiseSaying = wiseSayingRepository.save(wiseSaying);

        return savedWiseSaying;
    }

    public void modify(WiseSaying w1, String content, String author){
        w1.setContent(content);
        w1.setAuthor(author);
    }

    public boolean delete(int id){
        boolean rst=wiseSayingRepository.delete(id);

        return rst;
    }

    public List<WiseSaying> findAllIdDesc(){

        return wiseSayingRepository.findAllIdDesc();
    }
}
