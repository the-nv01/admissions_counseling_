package admissions_counseling.repository;

import admissions_counseling.model.Block;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<Block, Integer> {
    List<Block> findAllBy();

    Block getBlockByBlockName(String blockName);
}
