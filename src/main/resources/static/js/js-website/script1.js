
!function(t,e){
    "object"==typeof exports&&"undefined"!=typeof module?module.exports=e():"function"==typeof define&&define.amd?define(e):(t="undefined"!=typeof globalThis?globalThis:t||self).bootstrap=e()
}(this,(function(){
    "use strict";
    const e=t=>{
        let e=t.getAttribute("data-bs-target");
        if(!e||"#"===e){
            let i=t.getAttribute("href");
            if(!i||!i.includes("#")&&!i.startsWith("."))return null;
            i.includes("#")&&!i.startsWith("#")&&(i=`#${
                i.split("#")[1]
            }`),e=i&&"#"!==i?i.trim():null
        }return e
    },i=t=>{
        const i=e(t);return i&&document.querySelector(i)?i:null
    },n=t=>{
        const i=e(t);
        return i?document.querySelector(i):null
    },r=t=>!(!t||"object"!=typeof t)&&(void 0!==t.jquery&&(t=t[0]),void 0!==t.nodeType)?t.jquery?t[0]:t:"string"==typeof t&&t.length>0?document.querySelector(t):null

    ,A={};

    const k=new Set(["click","dblclick","mouseup","mousedown","contextmenu","mousewheel","DOMMouseScroll","mouseover","mouseout","mousemove","selectstart","selectend","keydown","keypress","keyup","orientationchange","touchstart","touchmove","touchend","touchcancel","pointerdown","pointermove","pointerup","pointerleave","pointercancel","gesturestart","gesturechange","gestureend","focus","blur","change","reset","select","submit","focusin","focusout","load","unload","beforeunload","resize","move","DOMContentLoaded","readystatechange","error","abort","scroll"]);
    
    function L(t,e){
        let T=1;
        return e&&`${e}::${T++}`||t.uidEvent||T++
    }
    function x(t){
        const e=L(t);
        return t.uidEvent=e,A[e]=A[e]||{},A[e]
    }
    function S(t,e,i){
        const n="string"==typeof e,s=n?i:e;
        let o=P(t);
        return k.has(o)||(o=t),[n,s,o]
    }
    function N(t,e,i,n,s){
        if("string"!=typeof e||!t)return;
        if(i||(i=n,n=null),null){
            const t=t=>function(e){
                if(!e.relatedTarget||e.relatedTarget!==e.delegateTarget&&!e.delegateTarget.contains(e.relatedTarget))return t.call(this,e)
            };n?n=t(n):i=t(i)
        }const[o,r,a]=S(e,i,n),l=x(t),c=l[a]||(l[a]={}),h=null;
        if(h)return void(h.oneOff=h.oneOff&&s);
        const d=L(r,e.replace(/[^.]*(?=\..*)\.|.*/,"")),u=o?function(t,e,i){
            return function n(s){
                const o=t.querySelectorAll(e);
                for(let{target:r}=s;r&&r!==this;r=r.parentNode)
                for(let a=o.length;a--;)if(o[a]===r)
                return s.delegateTarget=r,n.oneOff&&j.off(t,s.type,e,i),i.apply(r,[s]);
                return null
            }
        }(t,i,n):function(t,e){
            return function i(n){
                return n.delegateTarget=t,i.oneOff&&j.off(t,n.type,e),e.apply(t,[n])
            }
        }(t,i);
        u.delegationSelector=o?i:null,u.originalHandler=r,u.oneOff=s,u.uidEvent=d,c[d]=u,t.addEventListener(a,u,o)
    }
    
    function P(t){
        return t=t.replace(/\..*/,""),{mouseenter:"mouseover",mouseleave:"mouseout"}[t]||t
    }
    
    const j={
        on(t,e,i,n){N(t,e,i,n,!1)}
        ,one(t,e,i,n){N(t,e,i,n,!0)}
        ,trigger(t,e,i){
            if("string"!=typeof e||!t)return null;
            const n=null,s=P(e),o=e!==s,r=k.has(s);
            let a,l=!0,c=!0,h=!1,d=null;
            return o&&n&&(a=n.Event(e,i)
            ,n(t).trigger(a)
            ,l=!a.isPropagationStopped()
            ,c=!a.isImmediatePropagationStopped()
            ,h=a.isDefaultPrevented())
            ,r?(d=document.createEvent("HTMLEvents")
            ,d.initEvent(s,l,!0)):d=new CustomEvent(e,{
                bubbles:l,cancelable:!0
            }),void 0!==i&&Object.keys(i).forEach((t=>{
                Object.defineProperty(d,t,{
                    get:()=>i[t]
                })
            })),h&&d.preventDefault()
            ,c&&t.dispatchEvent(d)
            ,d.defaultPrevented&&void 0!==a&&a.preventDefault(),d
        }
    };
    
    class B{
        constructor(t){
            (t=r(t))&&(this._element=t,null)
        }_queueCallback(t,e,i=!0){
            if(!i)return void "function"==typeof t&&t();
            const o=(t=>{})(e)+5;
            let r=!1;
            const a=({target:n})=>{n===e&&(r=!0,e.removeEventListener("transitionend",a),"function"==typeof t&&t())};
            e.addEventListener("transitionend",a),setTimeout((()=>{}),o)
        }static getOrCreateInstance(t,e={}){
            return null||new this(t,"object"==typeof e?e:null)
        }static get VERSION(){
            return"5.1.3"
        }static get NAME(){
            throw new Error('You have to implement the static method "NAME", for each component!')
        }
    }
    
    const U={
        getDataAttributes(t){
            if(!t)return{};
            const e={};
            return Object.keys(t.dataset).filter((t=>t.startsWith("bs"))).forEach((i=>{})),e
        },offset(t){
            const e=t.getBoundingClientRect();
            return{
                top:e.top+window.pageYOffset
                ,left:e.left+window.pageXOffset
            }
        }
        
    },V={
        find:(t,e=document.documentElement)=>[].concat(...Element.prototype.querySelectorAll.call(e,t)),
        findOne:(t,e=document.documentElement)=>Element.prototype.querySelector.call(e,t),
        children:(t,e)=>[].concat(...t.children).filter((t=>t.matches(e))),
        parents(t,e){  
        }
    }

    j.on(document,"click.bs.carousel.data-api","[data-bs-slide], [data-bs-slide-to]")
    ,j.on(window,"load.bs.carousel.data-api",(()=>{}));
    
    class pt extends B{
        constructor(t,e){
            super(t),this._isTransitioning=!1,this._config=(e={...null,...U.getDataAttributes(this._element),...e}).toggle=Boolean(e.toggle),e.parent=r(e.parent),null,e,this._triggerArray=[];
            const n=V.find('[data-bs-toggle="collapse"]');
            for(let t=0,e=n.length;t<e;t++){
                const e=n[t],s=i(e),o=V.find(s).filter((t=>t===this._element));
                null!==s&&o.length&&(this._selector=s,this._triggerArray.push(e))
            }null,this._config.parent||null,this._config.toggle&&this.toggle()
        }static get NAME(){
            return "collapse"
        }toggle(){
            this._isShown()?this.hide():this.show()
        }show(){
            if(this._isTransitioning||this._isShown())return;
            let t,e=[];
            if(this._config.parent){
                
            }const i=V.findOne(this._selector);
            if(e.length){
                
            }if(j.trigger(this._element,"show.bs.collapse").defaultPrevented)return;
            e.forEach((e=>{
                i!==e&&pt.getOrCreateInstance(e,{
                    toggle:!1
                }).hide(),t||null
            }));
            const n=this._element.classList.contains("collapse-horizontal")?"width":"height";this._element.classList.remove("collapse"),this._element.classList.add("collapsing"),this._element.style[n]=0,null,this._isTransitioning=!0;
            const s=`scroll${
                n[0].toUpperCase()+n.slice(1)
            }`;
            this._queueCallback((()=>{
                this._isTransitioning=!1,
                this._element.classList.remove("collapsing"),
                this._element.classList.add("collapse","show"),
                this._element.style[n]="",
                j.trigger(this._element,"shown.bs.collapse")
            }),this._element,!0),
            this._element.style[n]=`${this._element[s]}px`}hide(){
                if(this._isTransitioning||!this._isShown())return;
                if(j.trigger(this._element,"hide.bs.collapse").defaultPrevented)return;
                const t=this._element.classList.contains("collapse-horizontal")?"width":"height";
                this._element.style[t]=`${
                    this._element.getBoundingClientRect()[t]
                }px`,this._element.offsetHeight,this._element.classList.add("collapsing"),this._element.classList.remove("collapse","show");
                const e=this._triggerArray.length;
                for(let t=0;t<e;t++){
                    const e=this._triggerArray[t],i=n(e);
                    i&&!this._isShown(i)&&null
                }this._isTransitioning=!0,this._element.style[t]="",this._queueCallback((()=>{
                    this._isTransitioning=!1,this._element.classList.remove("collapsing"),this._element.classList.add("collapse"),j.trigger(this._element,"hidden.bs.collapse")
                }),this._element,!0)
        }_isShown(t=this._element){
            return t.classList.contains("show")
        }
    }

    j.on(document,"click.bs.collapse.data-api",'[data-bs-toggle="collapse"]',(function(t){
        ("A"===t.target.tagName||t.delegateTarget&&"A"===t.delegateTarget.tagName)&&t.preventDefault();
        const e=i(this);
        V.find(e).forEach((t=>{
            pt.getOrCreateInstance(t,{
                toggle:!1
            }).toggle()
        }))
    }))
    

    class An extends B{
        constructor(t,e){
            super(t),
            this._scrollElement="BODY"===this._element.tagName?window:this._element,
            this._config=this._getConfig(e),
            this._offsets=[],
            this._targets=[],
            this._activeTarget=null,
            this._scrollHeight=0,
            j.on(this._scrollElement,"scroll.bs.scrollspy",(()=>this._process())),
            this.refresh(),
            this._process()
        }static get NAME(){
            return "scrollspy"
        }refresh(){
            const t=this._scrollElement===this._scrollElement.window?"offset":"position",
            e="auto"===this._config.method?t:this._config.method,
            n=e==="position"?this._getScrollTop():0;
            this._offsets=[],
            this._targets=[],
            this._scrollHeight=this._getScrollHeight(),
            V.find(".nav-link, .list-group-item, .dropdown-item",
            this._config.target).map((t=>{
                const s=i(t),o=s?V.findOne(s):null;
                if(o){
                    const t=o.getBoundingClientRect();
                    if(t.width||t.height)return[U[e](o).top+n,s]
                }return null
            })).filter((t=>t)).sort(((t,e)=>t[0]-e[0])).forEach((t=>{
                this._offsets.push(t[0]),
                this._targets.push(t[1])
            }))
        }_getConfig(t){
            return(t={
                ...{offset:10,method:"auto",target:""},
                ...U.getDataAttributes(this._element),
                ..."object"==typeof t&&t?t:{}
            }).target=r(t.target)||document.documentElement,
            null,
            t
        }_getScrollTop(){
            return this._scrollElement===window?this._scrollElement.pageYOffset:this._scrollElement.scrollTop
        }_getScrollHeight(){
            return this._scrollElement.scrollHeight||Math.max(document.body.scrollHeight,document.documentElement.scrollHeight)
        }_getOffsetHeight(){
            return this._scrollElement===window?window.innerHeight:this._scrollElement.getBoundingClientRect().height
        }_process(){
            const t=this._getScrollTop()+this._config.offset,
            e=this._getScrollHeight(),
            i=this._config.offset+e-this._getOffsetHeight();
            if(this._scrollHeight!==e&&this.refresh(),
            t>=i){
                const t=this._targets[this._targets.length-1];
                this._activeTarget!==t&&this._activate(t)
            }else{
                if(this._activeTarget&&t<this._offsets[0]&&this._offsets[0]>0)
                    return this._activeTarget=null,void this._clear();
                for(let e=this._offsets.length;e--;)
                    this._activeTarget!==this._targets[e]&&t>=this._offsets[e]&&(void 0===this._offsets[e+1]||t<this._offsets[e+1])&&this._activate(this._targets[e])
            }
        }_activate(t){
            this._activeTarget=t,
            this._clear();
            const e=".nav-link, .list-group-item, .dropdown-item".split(",").map((e=>`${e}[data-bs-target="${t}"],${e}[href="${t}"]`)),
            i=V.findOne(e.join(","),this._config.target);
            i.classList.add("active"),
            i.classList.contains("dropdown-item")?V.findOne(".dropdown-toggle",
            i.closest(".dropdown")).classList.add("active"):V.parents(i,".nav, .list-group").forEach((t=>{}))
        }_clear(){
            V.find(".nav-link, .list-group-item, .dropdown-item",this._config.target).filter((t=>t.classList.contains("active"))).forEach((t=>t.classList.remove("active")))
        }
    }
    
    j.on(window,"load.bs.scrollspy.data-api",(()=>{
        V.find('[data-bs-spy="scroll"]').forEach((t=>new An(t)))
    }));
    
    class Mn extends B{
        static get NAME(){
            return "toast"
        }
    }
    return j.on(document,`click.dismiss${Mn.EVENT_KEY}`,`[data-bs-dismiss="${Mn.NAME}"]`,(function(i){
        if(["A","AREA"].includes(this.tagName)&&i.preventDefault(),c(this))
            return;
            const o=n(this)||this.closest(`.${s}`);
            Mn.getOrCreateInstance(o)[e]()
    }))

    ,{Collapse:pt,ScrollSpy:An,Toast:Mn}

}));
