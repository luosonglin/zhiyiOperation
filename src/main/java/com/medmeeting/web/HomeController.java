package com.medmeeting.web;

import com.medmeeting.domain.Blog;
import com.medmeeting.manager.ManagerMapper;
import com.medmeeting.manager.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by luosonglin on 13/01/2017.
 */
@Controller
@RequestMapping("/")
public class HomeController extends BaseController{

    @Autowired
    ManagerMapper managerMapper;

    /**
     * 个人首页
     * @param model
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value="/user/{userId}/{favoritesId}")
//    @LoggerManage(description="个人首页")
    public String userPageShow(Model model,
                               @PathVariable("userId") Long userId,
                               @PathVariable("favoritesId") Long favoritesId,
                               @RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "15") Integer size){
//        User user = managerMapper.findOne(userId);
//        Long collectCount = 0l;
//        Sort sort = new Sort(Direction.DESC, "id");
//        Pageable pageable = new PageRequest(page, size, sort);
//        List<CollectSummary> collects = null;
//        Integer isFollow = 0;
//        if(getUserId().longValue() == userId.longValue()){
//            model.addAttribute("myself",IsDelete.YES.toString());
//            collectCount = collectRepository.countByUserIdAndIsDelete(userId,IsDelete.NO);
//            if(0 == favoritesId){
//                collects =collectService.getCollects("myself", userId, pageable,null,null);
//            }else{
//                collects =collectService.getCollects(String.valueOf(favoritesId), userId, pageable,0l,null);
//            }
//        }else{
//            model.addAttribute("myself",IsDelete.NO.toString());
//            collectCount = collectRepository.countByUserIdAndTypeAndIsDelete(userId, CollectType.PUBLIC, IsDelete.NO);
//            if(favoritesId == 0){
//                collects =collectService.getCollects("others", userId, pageable,null,getUserId());
//            }else{
//                collects = collectService.getCollects("otherpublic", userId, pageable, favoritesId,getUserId());
//            }
//            isFollow = followRepository.countByUserIdAndFollowIdAndStatus(getUserId(), userId, FollowStatus.FOLLOW);
//        }
//        Integer follow = followRepository.countByUserIdAndStatus(userId, FollowStatus.FOLLOW);
//        Integer followed = followRepository.countByFollowIdAndStatus(userId, FollowStatus.FOLLOW);
//        List<Favorites> favoritesList = favoritesRepository.findByUserId(userId);
//        List<String> followUser = followRepository.findFollowUserByUserId(userId);
//        List<String> followedUser = followRepository.findFollowedUserByFollowId(userId);
//        model.addAttribute("collectCount",collectCount);
//        model.addAttribute("follow",follow);
//        model.addAttribute("followed",followed);
//        model.addAttribute("user",user);
//        model.addAttribute("collects", collects);
//        model.addAttribute("favoritesList",favoritesList);
//        model.addAttribute("followUser",followUser);
//        model.addAttribute("followedUser",followedUser);
//        model.addAttribute("isFollow",isFollow);
//        return "user";
        return "404";
    }

    @RequestMapping(value="/standard/{type}/{userId}")
//    @LoggerManage(description="文章列表standard")
    public String standard(Model model,
                           @RequestParam(value = "page", defaultValue = "0") Integer page,
                           @RequestParam(value = "size", defaultValue = "15") Integer size,
                           @PathVariable("type") String type,
                           @PathVariable("userId") Long userId) {
        Sort sort = new Sort(Direction.DESC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        model.addAttribute("type", type);
//        Blog blog = new Blog();
//        Favorites favorites = new Favorites();
//        if(!"my".equals(type)&&!"explore".equals(type) && !"garbage".equals(type)){
//            try {
//                favorites = favoritesRepository.findOne(Long.parseLong(type));
//                favorites.setPublicCount(collectRepository.countByFavoritesIdAndTypeAndIsDelete(favorites.getId(), CollectType.PUBLIC,IsDelete.NO));
//            } catch (Exception e) {
//                logger.error("获取收藏夹异常：",e);
//            }
//        }
//        List<CollectSummary> collects = null;
//        if(null != userId && 0 != userId && userId.longValue() != getUserId().longValue()){
//            User user = userRepository.findOne(userId);
//            model.addAttribute("otherPeople", user);
//            collects =collectService.getCollects("otherpublic",userId, pageable,favorites.getId(),null);
//        }else{
//            collects =collectService.getCollects(type,getUserId(), pageable,null,null);
//        }
//        model.addAttribute("collects", collects);
//        model.addAttribute("favorites", favorites);
//        model.addAttribute("userId", getUserId());
//        model.addAttribute("size", collects.size());
//        logger.info("standard end :"+ getUserId());
        return "collect/standard";
    }
}
