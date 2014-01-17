package com.geno.calendrier;

import android.app.*;
import android.content.*;
import android.os.*;
import android.text.format.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.widget.CompoundButton.*;

import android.view.View.OnClickListener;

public class MainActivity extends Activity
{
	public static String[] mth = {"葡月","雾月","霜月","雪月","雨月","风月","芽月","花月","牧月","获月","热月","果月","无套裤汉日"};
	public static String[][] year = 
	{
		{"悬钩子日","藏红花日","野栗子日","秋水仙日","马日","凤仙花日","红萝卜日","雁来红日","欧洲防风日","酒槽日","马铃薯日","蜡菊日","笋瓜日","木犀草日","驴日","紫茉莉日","葫芦日","荞麦日","向日日","榨汁机日","大麻日","桃日","圆萝卜日","孤挺花日","牛日","茄日","辣椒日","西红柿日","大麦日","酒桶日"},
		{"苹果日","芹菜日","梨日","甜菜日","鹅日","紫草日","无花果日","雅葱日","花楸日","犁日","波罗门参日","菱角日","洋姜日","苦苣日","火鸡日","细叶芹日","水田芥日","兰茉莉日","石榴日","钉齿耙日","山葡萄日","意大利山楂日","茜草日","橙子日","雉鸡日","开心果日","马郁兰日","榅桲日","水榆日","辊筒日"},
		{"匍匐风铃草日","芜菁日","菊苣日","枇杷日","猪日","野苣日","菜花日","蜜花日","杜松子日","十字镐日","白腊树日","辣根日","雪松日","枞树日","狍子日","荆豆日","柏树日","常春藤日","杜松日","撅头日","糖槭日","石楠日","芦苇日","酸模日","蟋蟀日","五针松日","软木树日","块菰日","橄榄日","铁锨日"},
		{"泥炭日","煤日","沥青日","硫磺日","犬日","熔岩日","腐殖土日","肥料日","硝石日","连枷日","花岗岩日","黏土日","板岩日","砂岩日","兔日","燧石日","泥灰石日","石灰石日","大理石日","簸箕日","石膏日","盐日","铁日","铜日","猫日","锡日","铅日","锌日","汞日","筛子日"},
		{"桂叶芫花日","苔藓日","假叶树日","雪莲日","公牛日","荚蒾日","火绒草日","瑞香日","杨树日","斧头日","嚏根草日","芥蓝花日","月桂日","榛树日","母牛日","黄杨日","地衣日","紫杉日","疗肺草日","剪枝刀日","菥蓂日","欧石楠日","冰草日","鸭趾草日","野兔日","菘蓝日","榛子日","仙客来日","白屈菜日","拖网日"},
		{"款冬日","山茱萸日","堇菜日","女桢日","公山羊日","细辛日","泻鼠李日","紫罗兰日","黄华柳日","锹日","水仙日","榆树日","球果紫堇日","糖芥日","母山羊日","菠菜日","多榔菊日","繁缕日","欧芹日","钓鱼线日","曼德拉草日","香芹日","辣根菜日","雏菊日","金枪鱼日","蒲公英日","森林日","水龙骨日","梣树日","手铲日"},
		{"报春花日","法桐日","芦笋日","郁金香日","母鸡日","野甜菜日","桦树日","黄水仙日","桤木日","孵鸡房日","长春花日","鹅耳栎日","羊肚菌日","山毛榉日","蜜蜂日","生菜日","落叶松日","毒芹日","水萝卜日","蜂箱日","紫荆日","油麦菜日","栗树日","芝麻菜日","鸽子日","欧丁香日","秋牡丹日","三色堇日","越桔日","接枝刀日"},
		{"玫瑰日","橡树日","蕨日","山楂日","夜莺日","搂斗菜日","铃兰日","蘑菇日","风信子日","耙子日","大黄日","黄芪日","蒲草日","矮棕榈日","蚕日","聚合草日","地榆日","荠菜日","滨藜日","锄日","补血草日","贝母日","琉璃生菜日","缬草日","鲤鱼日","卫矛日","香葱日","牵牛花日","黑芥日","牧铲日"},
		{"苜蓿日","萱草日","三叶草日","当归日","鸭子日","蜜蜂花日","冬小麦日","头巾百合日","欧百里香日","长柄镰刀日","草莓日","药水苏日","豌豆日","金合欢日","鹌鹑日","石竹日","接骨木日","罂粟日","椴树日","长柄叉日","矢车菊日","洋甘菊日","忍冬日","猪殃殃日","冬穴鱼日","茉莉日","马鞭草日","百里香日","牡丹日","大板车日"},
		{"黑麦日","燕麦日","洋葱日","婆婆纳日","骡子日","迷迭香日","黄瓜日","分葱日","苦艾日","小镰刀日","芫荽日","大蓟日","丁子香日","熏衣草日","岩羊日","烟草日","醋栗日","香碗豆日","樱桃日","围栅日","薄荷日","莳萝日","菜豆日","阿看草日","珍珠鸡日","鼠尾草日","大蒜日","巢菜日","小麦日","芦笛日"},
		{"双粒小麦日","毒鱼藤日","甜瓜日","黑麦草日","公绵羊日","木贼日","蒿日","红花日","黑莓日","喷壶日","黍日","海蓬子日","杏日","罗勒日","母绵羊日","蜀葵日","亚麻日","扁桃日","龙胆日","闸门日","飞廉日","山柑日","扁小豆日","土木香日","水獭日","香桃木日","油菜日","羽扇豆日","棉花日","磨坊日"},
		{"李子日","小米日","马勃日","六棱大麦日","鲑鱼日","晚香玉日","六棱麦日","夹竹桃日","甘草日","梯子日","西瓜日","小茴香日","刺蘖日","核桃日","鳟鱼日","柠檬日","起绒草日","鼠李日","万寿菊日","背篓日","蔷薇日","榛子日","啤酒花日","高粱日","螯虾日","酸橙日","一枝黄花日","玉米日","大栗子日","篮子日"},
		{"道德日","才能日","工作日","舆论日","奖赏日","革命日"}
	};
	public int i;
	public int j;
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		final DatePicker d = (DatePicker) findViewById(R.id.date);
		final Button day = (Button) findViewById(R.id.day);
		final Button month = (Button) findViewById(R.id.month);
		Button dtos = (Button) findViewById(R.id.dtos);
		Button stod = (Button) findViewById(R.id.stod);
		Switch s = (Switch) findViewById(R.id.calendarsw);
		TextView times = (TextView)findViewById(R.id.tp);
		s.setChecked(true);
		final Time time = new Time();
		time.setToNow();
		int todayd = time.monthDay;
		int todaym = time.month;
		month.setOnClickListener
		(new OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{	
					AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this)
						.setTitle("Mois?")
						.setItems
						(mth, new DialogInterface.OnClickListener()
							{
								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									day.setText(year[p2][0]);
									month.setText(mth[p2]);
									i=p2;
								}
							}
						);
					ad.show();
					j=0;
				}
			}
		);
		day.setOnClickListener
		(new OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{	
					AlertDialog.Builder ad = new AlertDialog.Builder(MainActivity.this);
					ad.setTitle("Jour?");
					{ad.setItems
						(year[i],new DialogInterface.OnClickListener()
							{
								@Override
								public void onClick(DialogInterface p1, int p2)
								{
									j=p2;
									day.setText(year[i][p2]);
								}
							}
						);
						ad.show();
					}
				}
			}
		);
		s.setOnCheckedChangeListener
		(new OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton p1, boolean p2)
				{
					if(p2 == true)
					{
						d.setCalendarViewShown(true);
					}
					else
					{
						d.setCalendarViewShown(false);
					}
				}
			}
		);
		dtos.setOnClickListener
		(new OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					int m = d.getMonth();
					int a = d.getDayOfMonth();
					int y = d.getYear();
					int v = d.getYear()/4;
					int b = d.getYear()/100;
					int v400 = d.getYear()/400;
					int l = 0;
					if(4 * v == y)
					{
						if(100 * b != y)
							l=1;
						else
						{
							if(400 * v400 == y)
								l=1;
							else
								l=0;
						}
					}
					if(m==8)
					{
						if(a < 17-l)
						{
							month.setText(mth[11]);
							day.setText(year[11][a+13+l]);
							i=11;
							j=a+13+l;
						}
						else if(a < 22 && a >= 17-l)
						{
							month.setText(mth[12]);
							day.setText(year[12][a-17+l]);
							i=12;
							j=a-17+l;
						}
						else if(a>=22)
						{
							month.setText(mth[0]);
							day.setText(year[0][a-22]);
							i=0;
							j=a-22;
						}
					}
					if(m==9)
					{
						if(a<=21)
						{
							month.setText(mth[0]);
							day.setText(year[0][a+8]);
							i=0;
							j=a+8;
						}
						else
						{
							month.setText(mth[1]);
							day.setText(year[1][a-22]);
							i=1;
							j=a-22;
						}
					}
					if(m==10)
					{
						if(a<=20)
						{
							month.setText(mth[1]);
							day.setText(year[1][a+9]);
							i=1;
							j=a+9;
						}
						else
						{
							month.setText(mth[2]);
							day.setText(year[2][a-21]);
							i=2;
							j=a-21;
						}
					}
					if(m==11)
					{
						if(a<=20)
						{
							month.setText(mth[2]);
							day.setText(year[2][a+9]);
							i=2;
							j=a+9;
						}
						else
						{
							month.setText(mth[3]);
							day.setText(year[3][a-21]);
							i=3;
							j=a-21;
						}
					}
					if(m==0)
					{
						if(a<=19)
						{
							month.setText(mth[3]);
							day.setText(year[3][a+10]);
							i=3;
							j=a+10;
						}
						else
						{
							month.setText(mth[4]);
							day.setText(year[4][a-20]);
							i=4;
							j=a-20;
						}
					}
					if(m==1)
					{
						if(a<=18)
						{
							month.setText(mth[4]);
							day.setText(year[4][a+11]);
							i=4;
							j=a+11;
						}
						else
						{
							month.setText(mth[5]);
							day.setText(year[5][a-19]);
							i=5;
							j=a-19;
						}
					}
					if(m==2)
					{
						if(a<=20-l)
						{
							month.setText(mth[5]);
							day.setText(year[5][a+9+l]);
							i=5;
							j=a+9+l;
						}
						else
						{
							month.setText(mth[6]);
							day.setText(year[6][a-21+l]);
							i=6;
							j=a+l-21;
						}
					}
					if(m==3)
					{
						if(a<=19-l)
						{
							month.setText(mth[6]);
							day.setText(year[6][a+10+l]);
							i=6;
							j=a+l+10;
						}
						else
						{
							month.setText(mth[7]);
							day.setText(year[7][a-20+l]);
							i=7;
							j=a+l-20;
						}
					}
					if(m==4)
					{
						if(a<=19-l)
						{
							month.setText(mth[7]);
							day.setText(year[7][a+10+l]);
							i=7;
							j=a+l+10;
						}
						else
						{
							month.setText(mth[8]);
							day.setText(year[8][a-20+l]);
							i=8;
							j=a+l-20;
						}
					}
					if(m==5)
					{
						if(a<=18-l)
						{
							month.setText(mth[8]);
							day.setText(year[8][a+11+l]);
							i=8;
							j=a+l+11;
						}
						else
						{
							month.setText(mth[9]);
							day.setText(year[9][a-19+l]);
							i=9;
							j=a+l-19;
						}
					}
					if(m==6)
					{
						if(a<=18-l)
						{
							month.setText(mth[9]);
							day.setText(year[9][a+11+l]);
							i=9;
							j=a+l+11;
						}
						else
						{
							month.setText(mth[10]);
							day.setText(year[10][a-19+l]);
							i=10;
							j=a+l-19;
						}
					}
					if(m==7)
					{
						if(a<=17-l)
						{
							month.setText(mth[10]);
							day.setText(year[10][a+12+l]);
							i=10;
							j=a+l+12;
						}
						else
						{
							month.setText(mth[11]);
							day.setText(year[11][a-18+l]);
							i=11;
							j=a+l-18;
						}
					}
				}
			}
		);
		stod.setOnClickListener
		(new OnClickListener()
			{
				@Override
				public void onClick(View p1)
				{
					int y = d.getYear();
					int v = d.getYear()/4;
					int b = d.getYear()/100;
					int v400 = d.getYear()/400;
					int l = 0;
					if(4 * v == y)
					{
						if(100 * b != y)
							l=1;
						else
						{
							if(400 * v400 == y)
								l=1;
							else
								l=0;
						}
					}
					if(i==0)
					{
						if(j <= 8)
							d.updateDate(time.year,8,j+22);
						else
							d.updateDate(time.year,9,j-8);
					}
					if(i==1)
					{
						if(j <= 9)
							d.updateDate(time.year,9,j+22);
						else
							d.updateDate(time.year,10,j-9);
					}
					if(i==2)
					{
						if(j <= 9)
							d.updateDate(time.year,10,j+21);
						else
							d.updateDate(time.year,11,j-9);
					}
					if(i==3)
					{
						if(j <= 10)
							d.updateDate(time.year,11,j+21);
						else
							d.updateDate(time.year,0,j-10);
					}
					if(i==4)
					{
						if(j <= 11)
							d.updateDate(time.year,0,j+20);
						else
							d.updateDate(time.year,1,j-11);
					}
					if(i==5)
					{
						if(j <= 9+l)
							d.updateDate(time.year,1,j+19);
						else
							d.updateDate(time.year,2,j-9-l);
					}
					if(i==6)
					{
						if(j <= 10+l)
							d.updateDate(time.year,2,j+21-l);
						else
							d.updateDate(time.year,3,j-10-l);
					}
					if(i==7)
					{
						if(j <= 10+l)
							d.updateDate(time.year,3,j+20-l);
						else
							d.updateDate(time.year,4,j-10-l);
					}
					if(i==8)
					{
						if(j <= 11+l)
							d.updateDate(time.year,4,j+20-l);
						else
							d.updateDate(time.year,5,j-11-l);
					}
					if(i==9)
					{
						if(j <= 11+l)
							d.updateDate(time.year,5,j+19-l);
						else
							d.updateDate(time.year,6,j-11-l);
					}
					if(i==10)
					{
						if(j <= 12+l)
							d.updateDate(time.year,6,j+19-l);
						else
							d.updateDate(time.year,7,j-12-l);
					}
					if(i==11)
					{
						if(j <= 13+l)
							d.updateDate(time.year,7,j+18-l);
						else
							d.updateDate(time.year,8,j-13-l);
					}
					if(i==12)
							d.updateDate(time.year,8,j+17-l);
				}
			}
		);
//		while(true)
//		{
			int q = time.hour;
			int r = time.minute;
			int u = time.second;
			double p = q * 3600 + r * 60 + u ;
			p = p /0.864;
			int q2 = (int) p / 10000;
			int r2 = (int) ( p - 10000 * q2 )/100;
			int u2 = (int) (p - 10000 * q2 - 100 * r2 );
			times.setText(q2 +":"+r2+":"+u2);
//		}
	}
}
