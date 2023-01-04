package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.Block;
import admissions_counseling.repository.BlockRepository;
import admissions_counseling.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {
    @Autowired
    BlockRepository blockRepository;

    @Override
    public List<Block> getAllBlock() {
        return blockRepository.findAllBy();
    }

    @Override
    public Block getBlockByName(String blockName) {
        return blockRepository.getBlockByBlockName(blockName);
    }
}
