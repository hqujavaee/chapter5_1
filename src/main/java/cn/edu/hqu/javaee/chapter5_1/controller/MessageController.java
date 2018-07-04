package cn.edu.hqu.javaee.chapter5_1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.edu.hqu.javaee.chapter5_1.entity.Message;
import cn.edu.hqu.javaee.chapter5_1.service.MessageService;

@Controller
@RequestMapping("/message")
public class MessageController {
	@Autowired
	MessageService messageService;
	@RequestMapping(value="/{userName}",method=RequestMethod.GET)
	public String getMessageList(@PathVariable String userName,Model model) {
		List<Message> msgList=messageService.getMessageByUserName(userName);
		model.addAttribute("msgList", msgList);
		model.addAttribute("userName",userName);
		for(Message msg:msgList) {
			System.out.println(msg.getId());
			//System.out.println(msg.getPostedTime());
		}
		return "msg_list";
	}

}
