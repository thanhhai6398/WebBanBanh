<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<div class="pb-5 pt-3 pl-3" id="add-product">
        <h2 class="text-lg-center mb-5 mt-4 section-title">Thêm một sản phẩm mới</h2>
        <div class="container">
        <c:url value="/seller/product/edit?action=add" var="add"></c:url>
            <form action="${add}" method="POST" enctype="multipart/form-data">
                <div class="row">
                    <div class="col-md-8">
                        <div class="form-group row d-flex align-items-center">
                            <label for="inputName" class="col-sm-3 col-form-label">Tên sản phẩm</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputName" required
                                    placeholder="Bánh cookie" name="pName">
                            </div>
                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="category" class="col-sm-3 col-form-label">Phân loại</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="category" name="pCategory">
                                <c:forEach items="${listCate}" var="c">
                                	<option value="${c.cID}">${c.cName}</option>
                                </c:forEach>
                                    
                                </select>
                            </div>

                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="description" class="col-sm-3 col-form-label">Mô tả</label>
                            <div class="col-sm-9">
                                <textarea class="form-control" id="description" rows="3"
                                    placeholder="Mô tả sản phẩm" name="pDescs"></textarea>
                            </div>
                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="inputPrice" class="col-sm-3 col-form-label">Giá</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputPrice" required 
                                placeholder="100000" name="pPrice">
                            </div>
                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="inputAmount" class="col-sm-3 col-form-label">Số Lượng</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputAmount" required 
                                placeholder="100" name="pAmount">
                            </div>
                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="inputUnit" class="col-sm-3 col-form-label">Đơn vị</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputUnit" required 
                                placeholder="500g" name="pUnit">
                            </div>
                        </div>
                        <div class="form-group row d-flex align-items-center">
                            <label for="inputOrigin" class="col-sm-3 col-form-label">Xuất xứ</label>
                            <div class="col-sm-9">
                                <input type="text" class="form-control" id="inputOrigin" required
                                    placeholder="Việt Nam" name="pOrigin">
                            </div>
                        </div>
                        <div>
                            <div class="col-md-9 offset-md-3">
                                <input type="submit" class="btn btn-lg btn-success" value="Thêm và hiện sản phẩm">
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="image-upload">
                            <div class="image">
                                <img id="product-img" src="" alt="No image uploaded yet">
                            </div>
                        </div>
                        <input id="default-btn" type="file" name="pImage" hidden="">
                        <button type="button" id="custom-btn" onclick="defaultBtnActive()">Thêm ảnh</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
     
    <!-- Script -->
    
    <script>
        const defaultBtn = document.getElementById("default-btn");
        const customBtn = document.getElementById("#custom-btn");
        const img = document.querySelector("img");
        function defaultBtnActive() {

            defaultBtn.click();
        }
        defaultBtn.addEventListener("change", function () {
            const file = this.files[0];
            if (file) {
                const reader = new FileReader();
                reader.onload = function () {
                    const result = reader.result;
                    img.src = result;
                }
                reader.readAsDataURL(file);
            }

        });
    </script>
     
    <!-- Script -->