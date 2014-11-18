package com.skt.ssp.gw.service;

import com.skt.ssp.gw.vo.goods.IfGo001MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo001MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo002MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo003MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo004MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo0051MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo005MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo006MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo007MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo008MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo009MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo010MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo011MobResVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobReqVO;
import com.skt.ssp.gw.vo.goods.IfGo012MobResVO;

/**
 * Goods Service Interface (GoodsService)
 *
 * @author <a href="mailto:jetwo@in-sprit.com">ChoKyuJin</a>
 * @version $Id: GoodsService.java,v 1.1 2011/09/03 00:00:00 ChoKyuJin Express $
 */
public interface GoodsService {
	public void jmsGoods();
	public IfGo001MobResVO requestGoods001(IfGo001MobReqVO ifGo001MobReqVO);
	public IfGo002MobResVO requestGoods002(IfGo002MobReqVO ifGo002MobReqVO);
	public IfGo003MobResVO requestGoods003(IfGo003MobReqVO ifGo003MobReqVO);
	public IfGo004MobResVO requestGoods004(IfGo004MobReqVO ifGo004MobReqVO);
	public IfGo005MobResVO requestGoods005(IfGo005MobReqVO ifGo005MobReqVO);
	public IfGo0051MobResVO requestGoods0051(IfGo0051MobReqVO ifGo0051MobReqVO);
	public IfGo006MobResVO requestGoods006(IfGo006MobReqVO ifGo006MobReqVO);
	public IfGo007MobResVO requestGoods007(IfGo007MobReqVO ifGo007MobReqVO);
	public IfGo008MobResVO requestGoods008(IfGo008MobReqVO ifGo008MobReqVO);
	public IfGo009MobResVO requestGoods009(IfGo009MobReqVO ifGo009MobReqVO);
	public IfGo010MobResVO requestGoods010(IfGo010MobReqVO ifGo010MobReqVO);
	public IfGo011MobResVO requestGoods011(IfGo011MobReqVO ifGo011MobReqVO);
	public IfGo012MobResVO requestGoods012(IfGo012MobReqVO ifGo012MobReqVO);
}