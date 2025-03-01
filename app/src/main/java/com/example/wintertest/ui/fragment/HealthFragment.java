package com.example.wintertest.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wintertest.R;
import com.example.wintertest.adapter.HealthAdapter;
import com.example.wintertest.bean.Suggestion;
//import com.example.wintertest.gson.Health;
import com.example.wintertest.util.HttpUtil;
import com.example.wintertest.util.Utility;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class HealthFragment extends Fragment {
//    private Health.Result.Suggestion[] mlist ;
    private List<Suggestion> suggestionList = new ArrayList<>();
    private EditText mproblemEditText;
    private Button msearchButton;
    private HealthAdapter adapter;
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_health, container, false);
        mproblemEditText = view.findViewById(R.id.problem_editText);
        msearchButton = view.findViewById(R.id.search_button);
        RecyclerView recyclerView = view.findViewById(R.id.health_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new HealthAdapter();
        recyclerView.setAdapter(adapter);
        initClick();
        return view;
    }
    private void initClick() {
        msearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestHealth();
            }
        });
    }
    private void requestHealth() {
        String problem = mproblemEditText.getText().toString().trim();
        if (problem.equals("")) {
            Toast.makeText(getActivity(), "请输入问题", Toast.LENGTH_SHORT).show();
        }
        else if (problem.equals("失眠")) {
            suggestionList.clear();
            Suggestion insomnia = new Suggestion("失眠", "以下是一些缓解失眠的小妙招：\n" +
                    " \n" +
                    "生活习惯调整\n" +
                    " \n" +
                    "- 规律作息：每天尽量在相同时间上床睡觉和起床，形成固定的生物钟，比如每晚10点半左右上床，早上6点半左右起床，周末也不打乱作息。\n" +
                    " \n" +
                    "- 适度运动：白天进行适量有氧运动，像慢跑、游泳、瑜伽等，但不要在临近睡觉前剧烈运动。运动能促进身体新陈代谢，帮助放松身心，提升睡眠质量。\n" +
                    " \n" +
                    "睡眠环境优化\n" +
                    " \n" +
                    "- 营造安静氛围：使用隔音材料如隔音窗帘、隔音棉等，减少外界噪音干扰。也可戴耳塞或用白噪音机，播放雨声、海浪声等自然声音，帮助屏蔽噪音，使人放松入睡。\n" +
                    " \n" +
                    "- 调整卧室光线：入睡时保持卧室黑暗，因为光线会抑制褪黑素分泌，影响睡眠。可安装遮光性好的窗帘，或戴眼罩助眠。\n" +
                    " \n" +
                    "睡前放松技巧\n" +
                    " \n" +
                    "- 热水浴：睡前1-2小时泡热水澡，水温以38-40℃为宜，泡15-20分钟。热水能使身体放松，升高体温，随后体温下降会产生困意。\n" +
                    " \n" +
                    "- 冥想放松：睡前进行10-15分钟冥想，找舒适位置坐下或躺下，闭眼，专注呼吸，排除杂念。冥想能减轻压力和焦虑，让身心平静，更易入睡。\n" +
                    " \n" +
                    "- 穴位按摩：按摩太阳穴、百会穴、神门穴等有助于睡眠的穴位。如用食指或拇指轻轻按揉太阳穴，每次按揉1-2分钟，力度适中，以有酸胀感为宜。\n" +
                    " \n" +
                    "饮食调节\n" +
                    " \n" +
                    "- 喝温牛奶：牛奶含色氨酸，能促进褪黑素和血清素生成，助于睡眠。睡前半小时喝一杯温牛奶，可提升睡眠质量。\n" +
                    " \n" +
                    "- 食用助眠食物：适量吃香蕉、燕麦、坚果等富含镁、钾、维生素B6等助眠成分的食物。但睡前不宜吃太多，避免肠胃负担影响睡眠。");
            suggestionList.add(insomnia);
        }
            else if (problem.equals("焦虑")) {
                suggestionList.clear();
                Suggestion Anxiety = new Suggestion("焦虑", "运动放松\n" +
                        " \n" +
                        "- 有氧运动：进行如跑步、游泳、骑自行车等有氧运动，能促使身体分泌内啡肽和多巴胺，这些神经递质有助于改善情绪，减轻焦虑感。建议每周进行至少3次，每次30分钟以上的有氧运动。\n" +
                        " \n" +
                        "- 瑜伽与普拉提：通过瑜伽和普拉提的各种体式和呼吸练习，可以帮助身体放松，增强身体柔韧性的同时，还能调节神经系统，让内心平静下来，缓解焦虑情绪。\n" +
                        " \n" +
                        "心理调节\n" +
                        " \n" +
                        "- 深呼吸：找个安静舒适的地方坐下或躺下，闭上眼睛，慢慢地吸气，让空气充满腹部，使腹部像气球一样鼓起，然后再缓缓地呼气，感受腹部逐渐收缩，重复几次，可帮助放松身体，平静思绪。\n" +
                        " \n" +
                        "- 正面思考：当感到焦虑时，尝试用积极的自我对话取代消极的想法，多关注生活中的积极方面，肯定自己的能力和价值，增强自信心，减少焦虑的影响。\n" +
                        " \n" +
                        "- 专注当下：将注意力集中在当前正在做的事情上，用心去感受周围的环境和自身的体验，可通过冥想、正念等练习提高专注力，避免思绪飘向引发焦虑的事情，让身心回归平静。\n" +
                        " \n" +
                        "生活方式调整\n" +
                        " \n" +
                        "- 保证睡眠：每天保持7-8小时的高质量睡眠，良好的睡眠有助于身体和大脑恢复，稳定情绪，从而减轻焦虑症状。\n" +
                        " \n" +
                        "- 培养兴趣：投入到自己喜欢的活动中，如绘画、阅读、听音乐等，能转移注意力，让你沉浸在愉悦的体验中，忘却焦虑，放松身心。\n" +
                        " \n" +
                        "环境优化\n" +
                        " \n" +
                        "- 亲近自然：前往公园、郊外等自然环境中散步或静坐，呼吸新鲜空气，欣赏自然美景，自然的宁静与和谐能抚慰心灵，缓解焦虑情绪。\n" +
                        " \n" +
                        "- 布置空间：将居住或工作空间布置得温馨、舒适、整洁，让自己处于一个宜人的环境中，有助于放松心情，减少焦虑的产生。");
                suggestionList.add(Anxiety);
            }
            else if (problem.equals("脱发")) {
                suggestionList.clear();
                Suggestion hairLoss = new Suggestion("脱发", "生活习惯方面\n" +
                        " \n" +
                        "- 保证充足睡眠：长期熬夜会打乱生物钟，影响身体的正常代谢，从而加重脱发。每天应保证7-8小时的高质量睡眠，让身体得到充分休息，促进头皮血液循环，为头发生长提供良好的环境。\n" +
                        " \n" +
                        "- 减少精神压力：长期精神紧张会使毛囊收缩，影响头发的生长。可通过运动、冥想、听音乐等方式来缓解压力，放松身心，如每周进行3-4次，每次30分钟左右的瑜伽练习，能有效减轻精神压力，预防脱发。\n" +
                        " \n" +
                        "饮食调节方面\n" +
                        " \n" +
                        "- 增加蛋白质摄入：头发的主要成分是角蛋白，摄入足够的蛋白质有助于头发生长。可多吃鸡肉、鱼肉、豆类、蛋类等富含优质蛋白质的食物，保证每天蛋白质的摄入量占总热量的10%-20%。\n" +
                        " \n" +
                        "- 补充维生素和矿物质：维生素B族、维生素E、铁、锌等对头发健康至关重要。可多吃新鲜蔬菜和水果，如菠菜、香蕉、橙子等补充维生素，吃瘦肉、海鲜等补充矿物质。\n" +
                        " \n" +
                        "头发护理方面\n" +
                        " \n" +
                        "- 使用合适的洗发水：根据自己的发质选择匹配的头发洗护产品，比如干性发质选择滋润型洗发水，油性发质选择控油型洗发水。避免使用含有硫酸盐、硅油等可能刺激头皮成分的洗发水。\n" +
                        " \n" +
                        "- 减少烫染次数：烫染剂中的化学物质会损伤头发和毛囊，建议每年烫染次数不超过2次，给头发足够的恢复时间，保护头发健康。\n" +
                        " \n" +
                        "头皮按摩方面\n" +
                        " \n" +
                        "- 日常按摩：每天早晚用指腹轻轻按摩头皮，以画圈的方式从额头向脑后按摩，每次按摩3-5分钟，促进头皮血液循环，为毛囊提供更多的营养，从而促进头发生长。\n" +
                        " \n" +
                        "- 借助工具：也可以使用头皮按摩器等工具辅助按摩，能更均匀地刺激头皮，一般每周使用2-3次，每次5-10分钟即可。");
                suggestionList.add(hairLoss);
            }
            else  {
                Toast.makeText(getActivity(), "暂不支持查询该症状", Toast.LENGTH_SHORT).show();
            }
            if (adapter != null) {
                adapter.setSuggestion(suggestionList);
                adapter.notifyDataSetChanged();
            } else {
                Log.e("HealthFragment", "HealthAdapter is not initialized");
            }
//        String healthUrl = "https://whyta.cn/api/tx/healthskill?{API_KEY}&word={problem}";
//        String API_KEY = "26c415f649a620501e890e47bf013740";
//        String healthUrl1 = healthUrl.replace("{problem}", problem).replace("{API_KEY}", API_KEY);
//        HttpUtil.sendOkHttpRequest(healthUrl1, new Callback() {
//            @Override
//            public void onFailure(@NonNull Call call, @NonNull IOException e) {
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (getActivity() != null) {
//                            Toast.makeText(getActivity(), "获取信息失败", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//            }
//            @Override
//            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
//                String responseText = response.body().string();
//                getActivity().runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        responseHealth(responseText);
//
//                        }
//                        public void responseHealth(String responseText) {
//                            Gson gson = new Gson();
//                            Health health = gson.fromJson(responseText, Health.class);
//                            Log.d("HealthFragment", "responseHealth: " + responseText);
//                            if (health != null ) {
//                                Health.Result result = health.getResult();
//                                if (result != null) {
//                                    Health.Result.Suggestion[] suggestions = result.getSuggestions();
//                                    if (suggestions != null){
//                                        for (Health.Result.Suggestion suggestion : suggestions) {
//                                            if (suggestion != null) {
//                                                mlist = suggestions;
//                                                adapter.notifyDataSetChanged();
//                                            }
//                                        }
//                                    }
//                                }
//                            }
//                       }
//                });
//            }
//        });
        }
}