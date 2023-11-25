import { Link } from "react-router-dom";
export default function Nav(){




    return (
    <div className={`z-40 fixed w-full flex flex-wrap justify-between mr-10 font-roboto text-white bg-gray-900 h-[60px]`}>
        <div className="italic flex text-3xl ml-10 cursor-pointer font-bold items-center"><div>Nykaa</div></div>
        <div className="flex text-xl ml-10 cursor-pointer font-semibold items-center mr-10"><Link to='/products'>Products</Link></div>


    </div>
    )
}