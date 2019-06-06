package top.alexmmd.luckymoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.alexmmd.luckymoney.domain.Luckymoney;

/**
 * @author 汪永晖
 */
public interface LuckymoneyRepository extends JpaRepository<Luckymoney, Integer> {
}
