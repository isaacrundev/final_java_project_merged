package com.company_mngm_sys.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.company_mngm_sys.demo.dao.LoginRepo2iyo;
import com.company_mngm_sys.demo.entity.Login2iyo;


@Controller 
@RequestMapping("/")
public class LoginController2iyo {

    @Autowired
    LoginRepo2iyo loginRepo2;

    @GetMapping
    public String home(Model model) {
        return "/products/index2iyo";
    }

    // templateのhtmlでformのactionに指定したパス
    @PostMapping("/doLogin")

    // RequestParamでFormの各アイテムに入力した値を取得する
    public String login(@RequestParam String name, @RequestParam int birthday){

        // Repositoryで定義した名前での検索メソッドnameはformで入力したfullNameが入っている
        List<Login2iyo> authUsers = loginRepo2.findByFullName(name);


        // 入力された名前で1件もレコードが見つからなかった場合、ログイン画面に戻す
        if(authUsers.size() == 0){
            return "/products/index2iyo";
        }

        // 入力された名前で見つかったレコードの内一番上のレコードの誕生日とフォームで入力された誕生日を比較
        if(authUsers.get(0).getBirthday() == birthday){
            // マッチすれば商品一覧へ
            return "redirect:/employees";

        }else{
            // アンマッチならログイン画面に戻す
            return "/products/index2iyo";
        }
        
    }

    



}
