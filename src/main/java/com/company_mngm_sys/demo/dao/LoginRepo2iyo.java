package com.company_mngm_sys.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.company_mngm_sys.demo.entity.Login2iyo;

// リポジトリを定義
// フォームに入力された名前とマッチするユーザーを取得するため、クエリをカスタマイズ
@Repository
public interface LoginRepo2iyo extends JpaRepository <Login2iyo, String> {
    
    // ?の所には引数のfullNameが挿入されて実行される
    @Query(nativeQuery = true, value = "SELECT * FROM employees WHERE full_name = ?1")
    List<Login2iyo> findByFullName(String fullName);
   
   

}

