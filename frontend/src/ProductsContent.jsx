import { useState } from "react";
export default function ProductsContent(){

const [productsResponse,setProductsResponse]=useState(null);

    useEffect(() => {
        const data={};
        axios.post("", data, {
            headers: {
                'Content-Type': 'application/json'
        }
        })
        .then((response) => {
            const confirmResponse=response.data;
            if(response.status === 200){
                // JSON Product Object
                console.log(confirmResponse);
                setProductsResponse(confirmResponse);
            }
            else {
                console.error('Request failed');
            }
        })
        .catch((error)=>{
            console.error(error.response.data.error);
        })
       
      }, []);
    
    
    
    
      return (
        <div>
            
        </div>
    )
}