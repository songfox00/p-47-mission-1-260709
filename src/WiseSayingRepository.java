import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class WiseSayingRepository {

    ArrayList<WiseSaying> wiseSayings= new ArrayList<>();
    int lastId=0;

    public int findIndexById(int id){

        return IntStream.range(0, wiseSayings.size())
                .filter(i -> wiseSayings.get(i).getId() == id)
                .findFirst()
                .orElse(-1);
    }

    public WiseSaying findById(int id){
        int idx = findIndexById(id);
        if(idx==-1)
            return null;

        return wiseSayings.get(idx);
    }

    public WiseSaying save(WiseSaying wiseSaying){
        lastId++;
        wiseSaying.setId(lastId);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public boolean delete(int id){
        boolean rst = wiseSayings.removeIf(
                wiseSaying -> wiseSaying.getId()==id
        );

        return rst;
    }

    public List<WiseSaying> findAllIdDesc(){

        return wiseSayings.reversed();
    }
}
