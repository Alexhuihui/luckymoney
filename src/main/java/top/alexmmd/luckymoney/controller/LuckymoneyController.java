package top.alexmmd.luckymoney.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.alexmmd.luckymoney.domain.Luckymoney;
import top.alexmmd.luckymoney.repository.LuckymoneyRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @author 汪永晖
 */
@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository luckymoneyRepository;

    /**
     * 获取红包列表
     *
     * @return
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return luckymoneyRepository.findAll();
    }

    /**
     * 创建红包（发红包）
     */
    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setMoney(money);
        luckymoney.setProducer(producer);
        return luckymoneyRepository.save(luckymoney);
    }

    /**
     * 通过ID查询红包
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return luckymoneyRepository.findById(id).orElse(null);
    }

    /**
     * 更新红包（领红包）
     */
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("consumer") String consumer) {
        Optional<Luckymoney> optionalLuckymoney = luckymoneyRepository.findById(id);
        if (optionalLuckymoney.isPresent()) {
            Luckymoney luckymoney = optionalLuckymoney.get();
            luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return luckymoneyRepository.save(luckymoney);
        }
        return null;
    }
}
