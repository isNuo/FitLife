package com.milotnt.controller;

import com.milotnt.pojo.Member;
import com.milotnt.pojo.MemberPayment;
import com.milotnt.service.MemberService;
import com.milotnt.service.MemberPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * 管理员系统的会员管理、会员卡查询和会员卡缴费
 */

@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberPaymentService memberPaymentService;

    /*会员管理*/

    //查询会员个人信息
    @RequestMapping("/selMember")
    public String selectMember(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "selectMember";
    }

    //跳转新增会员页面
    @RequestMapping("/toAddMember")
    public String toAddMember() {
        return "addMember";
    }

    //新增会员
    @RequestMapping("/addMember")
    public String addMember(Member member) {
        //会员账号&卡号随机生成
        Random random = new Random();
        String account1 = "2021";
        for (int i = 0; i < 5; i++) {
            account1 += random.nextInt(10);
        }
        Integer account = Integer.parseInt(account1);

        //初始密码
        String password = "123456";

        //获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

//        Integer remainClass = member.getCardRemainClass();

        member.setMemberAccount(account);
        member.setMemberPassword(password);
        member.setCardTime(nowDay);
//        member.setCardRemainClass(remainClass);

        memberService.insertMember(member);

        return "redirect:selMember";

    }

    //删除会员
    @RequestMapping("/delMember")
    public String deleteMember(Integer memberAccount) {
        memberService.deleteByMemberAccount(memberAccount);
        return "redirect:selMember";
    }

    //跳转会员修改页面
    @RequestMapping("/toUpdateMember")
    public String toUpdateMember(Integer memberAccount, Model model) {
        Member member = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("member", member);
        return "updateMember";
    }

    //修改会员信息
    @RequestMapping("/updateMember")
    public String updateMember(Member member) {
        memberService.updateMemberByMemberAccount(member);
        return "redirect:selMember";
    }

    /*会员卡查询*/

    //跳转会员卡查询页面
    @RequestMapping("/toSelByCard")
    public String toSelectByCardId() {
        return "selectByMemberAccount";
    }

    //根据会员卡号查询
    @RequestMapping("/selByCard")
    public String selectByCardId(Model model, Integer memberAccount) {
        Member memberList = memberService.selectByMemberAccount(memberAccount);
        if (memberList != null) {
            model.addAttribute("memberList", memberList);
        } else {
            String message = "会员卡号不存在！";
            model.addAttribute("noMessage", message);
        }
        return "selectByMemberAccount";
    }

    //查询对应会员卡缴费记录
    @RequestMapping("/selMemberPayment")
    public String selectMemberPayment(Integer memberAccount, Model model) {
        List<MemberPayment> memberPaymentList = memberPaymentService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberPaymentList", memberPaymentList);
        return "selectMemberPayment";
    }

    /*会员卡缴费管理*/

    //查询会员卡信息
    @RequestMapping("/selMembership")
    public String selectMembership(Model model) {
        List<Member> memberList = memberService.findAll();
        model.addAttribute("memberList", memberList);
        return "selectMembership";
    }

    //跳转会员卡充值界面
    @RequestMapping("/toUpdateBalance")
    public String toUpdateBalance(Integer memberAccount, Model model) {
        Member member = memberService.selectByMemberAccount(memberAccount);
        model.addAttribute("member", member);
        return "updateBalance";
    }

    //会员卡充值（更新会员卡信息和添加会员充值记录）
    @RequestMapping("/updateBalance")
    public String updateBalance(Integer memberAccount, Integer rechargeAmount) {
        MemberPayment memberPayment = new MemberPayment();

        //获取当前日期
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDay = simpleDateFormat.format(date);

        memberPayment.setMemberAccount(memberAccount);
        memberPayment.setRechargeAmount(rechargeAmount);
        memberPayment.setRechargeTime(nowDay);

        memberPaymentService.insertMemberPayment(memberPayment);

        Member member = memberService.selectByMemberAccount(memberAccount);
        Integer balance = member.getCardBalance();
        balance += rechargeAmount;
        member.setCardBalance(balance);

        memberService.updateMemberByMemberAccount(member);

        return "redirect:selMembership";
    }

    //查询对应会员卡缴费记录
    @RequestMapping("/selCardPayment")
    public String selectCardPayment(Integer memberAccount, Model model) {
        List<MemberPayment> memberPaymentList = memberPaymentService.selectByMemberAccount(memberAccount);
        model.addAttribute("memberPaymentList", memberPaymentList);
        return "selectCardPayment";
    }

}
